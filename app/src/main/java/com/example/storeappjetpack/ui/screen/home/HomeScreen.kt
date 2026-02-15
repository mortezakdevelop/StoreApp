package com.example.storeappjetpack.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    state: HomeState,
    onIntent: (HomeIntent) -> Unit
) {
    Column(Modifier
        .fillMaxSize()
        .systemBarsPadding()) {

        HomeSearchBar(
            query = state.querySearch,
            onQueryChange = { onIntent(HomeIntent.OnSearchQueryChange(it)) },
            onSearch = { onIntent(HomeIntent.OnSearchSubmit) }
        )

        //Text("Query: ${state.querySearch}", modifier = Modifier.padding(16.dp))

        BannerScreen(
            state = state,
            onBannerClick = { onIntent(HomeIntent.OnBannerClick(it)) }
        )
        // بقیه بخش‌های Home...
    }
}