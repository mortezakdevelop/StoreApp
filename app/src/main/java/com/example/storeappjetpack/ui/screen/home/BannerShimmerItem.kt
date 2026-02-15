package com.example.storeappjetpack.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.storeappjetpack.ui.utils.extensions.Extensions.shimmer

@Composable
fun BannerShimmerItem(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(width = 300.dp, height = 180.dp)
            .clip(RoundedCornerShape(16.dp))
            .shimmer()
    )
}