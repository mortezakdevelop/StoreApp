package com.example.storeappjetpack.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeappjetpack.domain.model.BannerModel


@Composable
fun BannerScreen(
    state: HomeState,
    onBannerClick: (BannerModel) -> Unit
) {
    when {
        state.isLoading -> {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(3) {
                    BannerShimmerItem()
                }
            }
        }

        state.errorText != null -> {
        }

        state.banners.isNotEmpty() -> {
            //without auto scroll
         /*   BannerSlider(
                banners = state.banners,
                onBannerClick = onBannerClick
            )*/

            BannerSliderInfiniteScroll(
                banners = state.banners,
                onBannerClick = onBannerClick
            )
        }
    }
}