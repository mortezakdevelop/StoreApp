package com.example.storeappjetpack.ui.screen.splash

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun SplashRoute(
    onNavigateHome: () -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.progressIntent(SplashIntent.Start)

        viewModel.effect.collect { effect ->
            when (effect) {
                SplashEffect.NavigateHome -> onNavigateHome()
                is SplashEffect.ShowToast ->
                    Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    SplashScreen(
        isNetworkAvailable = state.isNetworkAvailable,
        onRetryClick = { viewModel.progressIntent(SplashIntent.Retry) }
    )
}