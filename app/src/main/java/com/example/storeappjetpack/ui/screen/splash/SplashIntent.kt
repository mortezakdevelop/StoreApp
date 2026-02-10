package com.example.storeappjetpack.ui.screen.splash

sealed interface SplashIntent {
    data object Start : SplashIntent
    data object Retry : SplashIntent
}
