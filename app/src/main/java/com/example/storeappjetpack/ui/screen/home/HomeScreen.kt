package com.example.storeappjetpack.ui.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    state: HomeState,
    onIntent: (HomeIntent) -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        BannerScreen(
            state = state,
            onRetry = { onIntent(HomeIntent.Retry) },
            onBannerClick = { onIntent(HomeIntent.OnBannerClick(it)) }
        )
        // بقیه بخش‌های Home...
    }
}