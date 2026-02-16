package com.example.storeappjetpack.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.storeappjetpack.domain.model.HomeCategoryModel

@Composable
fun HomeCategoryScreen(
    state: HomeState,
    onCategoryClick: (HomeCategoryModel) -> Unit
){

    when {
        state.isCategoryLoading -> {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(6) {
                  HomeCategoryShimmerItem()
                }
            }
        }

        state.categoriesError != null -> {

        }

        state.category.isNotEmpty() -> {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.category, key = { it.id }) { cat ->
                        CategoryItem(item = cat, onClick = { onCategoryClick(cat) })
                    }
                }
            }
        }
    }
}