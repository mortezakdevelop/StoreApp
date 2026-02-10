package com.example.storeappjetpack.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.storeappjetpack.domain.model.BannerModel
import com.example.storeappjetpack.ui.component.Loading3Dots


@Composable
fun BannerScreen(
    state: HomeState,
    onRetry: () -> Unit,
    onBannerClick: (BannerModel) -> Unit
) {
    when {
        state.isLoading -> {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentAlignment = Alignment.Center
            ) {
                Loading3Dots(isDark = false, size = 48.dp)
            }
        }

        state.errorText != null -> {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(state.errorText)
                Spacer(Modifier.height(8.dp))
                Button(onClick = onRetry) { Text("تلاش مجدد") }
            }
        }

        state.banners.isNotEmpty() -> {
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(state.banners, key = { it.id }) { banner ->
                    GlideBannerItem(
                        banner = banner,
                        onClick = { onBannerClick(banner) }
                    )
                }
            }
        }
    }
}