package com.example.storeappjetpack.ui.screen.splash

sealed interface SplashEffect {
    data object NavigateHome : SplashEffect
    data class ShowToast(val message: String) : SplashEffect
}
