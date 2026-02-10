package com.example.storeappjetpack.ui.screen.home

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeRoute(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.effect.collectLatest { effect ->
            when(effect){
                is HomeEffect.ShowToast -> Toast.makeText(context,effect.message, Toast.LENGTH_SHORT).show()
                is HomeEffect.OpenBanner -> {
                    //navigate to another screen
                }
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        BannerScreen(
            state = state,
            onRetry = {viewModel.progressIntent(HomeIntent.Retry)},
            onBannerClick = { viewModel.progressIntent(HomeIntent.OnBannerClick(it))}
        )

        //continue home screens
    }
}