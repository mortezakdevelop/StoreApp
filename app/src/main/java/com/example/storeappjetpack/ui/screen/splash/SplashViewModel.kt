package com.example.storeappjetpack.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeappjetpack.ui.core.NetworkChecker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val networkChecker: NetworkChecker
): ViewModel() {

    private val _state = MutableStateFlow(SplashState())
    val state: StateFlow<SplashState> = _state

    private val _effect = MutableSharedFlow<SplashEffect>()
    val effect: SharedFlow<SplashEffect> = _effect


    fun progressIntent(intent: SplashIntent){
        when(intent){
            SplashIntent.Retry -> retry()
            SplashIntent.Start -> start()
        }
    }


    private fun retry() = viewModelScope.launch {
        val ok = networkChecker.isNetworkAvailable()
        _state.value = _state.value.copy(isNetworkAvailable = ok)

        if (ok) {
            _effect.emit(SplashEffect.NavigateHome)
        } else {
            _effect.emit(SplashEffect.ShowToast("اینترنت را بررسی کنید"))
        }
    }

    private fun start() = viewModelScope.launch {
        // نمایش وضعیت شبکه در UI
        _state.value = _state.value.copy(isNetworkAvailable = networkChecker.isNetworkAvailable())

        delay(1000)

        if (networkChecker.isNetworkAvailable()) {
            _effect.emit(SplashEffect.NavigateHome)
        } else {
            _state.value = _state.value.copy(isNetworkAvailable = false)
            _effect.emit(SplashEffect.ShowToast("اینترنت را بررسی کنید"))
        }
    }
}