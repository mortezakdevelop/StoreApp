package com.example.storeappjetpack.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeappjetpack.domain.AppError
import com.example.storeappjetpack.domain.ResponseResult
import com.example.storeappjetpack.domain.usecase.GetBannerHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBannerHomeUseCase: GetBannerHomeUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    private val _effect = MutableSharedFlow<HomeEffect>()
    val effect: SharedFlow<HomeEffect> = _effect

    init {
        loadBanners()
    }

    fun progressIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.OnBannerClick -> viewModelScope.launch {
                _effect.emit(HomeEffect.OpenBanner(intent.banner.type, intent.banner.link))
            }

            is HomeIntent.OnSearchQueryChange -> _state.update {
                it.copy(querySearch = intent.query)
            }

            is HomeIntent.OnSearchSubmit -> {
                //call api when search something
            }
        }
    }

    private fun loadBanners() = viewModelScope.launch {
        _state.update { it.copy(isLoading = true, errorText = null) }

        when (val result = getBannerHomeUseCase()) {
            is ResponseResult.Success -> {
                _state.update { it.copy(isLoading = false, banners = result.data) }
            }

            is ResponseResult.Error -> {
                val msg = result.error.toUiMessage()
                _state.update { it.copy(isLoading = false, errorText = msg) }
                _effect.emit(HomeEffect.ShowToast(msg))
            }
        }
    }

    private fun AppError.toUiMessage(): String = when (this) {
        AppError.Network -> "اینترنت در دسترس نیست"
        AppError.Timeout -> "سرور پاسخ نداد (Timeout)"
        is AppError.Http -> "خطای سرور: ${this.code}"
        AppError.Parsing -> "خطا در پردازش اطلاعات"
        is AppError.Unknown -> "خطای ناشناخته"
    }
}