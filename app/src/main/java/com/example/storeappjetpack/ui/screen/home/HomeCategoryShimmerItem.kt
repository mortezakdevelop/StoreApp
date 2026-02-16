package com.example.storeappjetpack.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.storeappjetpack.ui.utils.extensions.Extensions.shimmer

@Composable
fun HomeCategoryShimmerItem() {
    Box(
        Modifier
            .width(65.dp)
            .height(85.dp)
            .padding(paddingValues = PaddingValues(top = 16.dp, bottom = 16.dp))
            .clip(RoundedCornerShape(8.dp))
            .shimmer()
    )
}