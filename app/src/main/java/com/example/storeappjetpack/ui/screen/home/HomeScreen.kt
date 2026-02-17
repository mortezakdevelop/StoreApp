package com.example.storeappjetpack.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
        HomeCategoryScreen(
            state = state,
            onCategoryClick = {onIntent(HomeIntent.OnCategoryClick(it))}
        )

        AmazingProductsRow(
            products = state.amazing,
            onProductClick = { productId ->
                onIntent(HomeIntent.OnAmazingClick(productId))
            }
        )

        //continue home ...
    }
}