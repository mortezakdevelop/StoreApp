package com.example.storeappjetpack.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeappjetpack.domain.AppError
import com.example.storeappjetpack.domain.ResponseResult
import com.example.storeappjetpack.domain.usecase.GetBannerHomeUseCase
import com.example.storeappjetpack.domain.usecase.GetHomeAmazingUseCase
import com.example.storeappjetpack.domain.usecase.GetHomeCategoryUseCase
import com.example.storeappjetpack.ui.screen.home.HomeEffect.*
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
    private val getBannerHomeUseCase: GetBannerHomeUseCase,
    private val getHomeCategoryUseCase: GetHomeCategoryUseCase,
    private val getHOmeAmazingUseCase: GetHomeAmazingUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    private val _effect = MutableSharedFlow<HomeEffect>()
    val effect: SharedFlow<HomeEffect> = _effect

    init {
        loadBanners()
        loadHomeCategory()
        loadHomeAmazing()
    }

    fun progressIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.OnBannerClick -> viewModelScope.launch {
                _effect.emit(OpenBanner(intent.banner.type, intent.banner.link))
            }

            is HomeIntent.OnSearchQueryChange -> _state.update {
                it.copy(querySearch = intent.query)
            }

            is HomeIntent.OnSearchSubmit -> {
                //call api when search something
            }

            is HomeIntent.OnCategoryClick -> viewModelScope.launch {
                _effect.emit(OpenCategory(intent.category.id))
            }

            is HomeIntent.OnAmazingClick -> viewModelScope.launch {
                _effect.emit(OpenAmazing(intent.id))
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

    private fun loadHomeCategory() = viewModelScope.launch {
        _state.update { it.copy(isCategoryLoading = true,errorText = null) }

        when (val result = getHomeCategoryUseCase()){
            is ResponseResult.Success -> {
                _state.update { it.copy(isCategoryLoading = false, category = result.data) }
            }
            is ResponseResult.Error -> {
                val message = result.error.toUiMessage()
                _state.update { it.copy(isCategoryLoading = false, errorText = message) }
                _effect.emit(HomeEffect.ShowToast(message))
            }
        }
    }

    private fun loadHomeAmazing() = viewModelScope.launch {
        _state.update { it.copy(isAmazingLoading = true, errorText = null) }

        when(val result = getHOmeAmazingUseCase()){
            is ResponseResult.Success -> {
                _state.update { it.copy(isAmazingLoading = false, amazing = result.data ) }
            }
            is ResponseResult.Error -> {
                val message = result.error.toUiMessage()
                _state.update { it.copy(isAmazingLoading = false, errorText = message) }
                _effect.emit(HomeEffect.ShowToast(message))
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