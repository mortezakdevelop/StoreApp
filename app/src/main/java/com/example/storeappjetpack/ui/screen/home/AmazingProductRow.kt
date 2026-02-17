package com.example.storeappjetpack.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.storeappjetpack.domain.model.HomeAmazingModel

@Composable
fun AmazingProductsRow(
    products: List<HomeAmazingModel>,
    onProductClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    if (products.isEmpty()) return

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
        LazyRow(
            modifier = modifier
                .fillMaxWidth()
                .height(280.dp)
                .background(Color(0xFF66C96A))
                .padding(4.dp),
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            item {
                AmazingFirstItem(
                    onClick = { }
                )
            }

            items(products, key = { it.id }) { product ->
                AmazingProductItem(
                    product = product,
                    onClick = { onProductClick(product.id) }
                )
            }
        }
    }
}