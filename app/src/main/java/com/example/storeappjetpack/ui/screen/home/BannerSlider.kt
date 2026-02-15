package com.example.storeappjetpack.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeappjetpack.domain.model.BannerModel

@Composable
fun BannerSlider(
    banners: List<BannerModel>,
    onBannerClick: (BannerModel) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { banners.size }
    )

    Column(modifier = modifier.fillMaxWidth()) {

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 12.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) { page ->
            val banner = banners[page]
            GlideBannerItem(
                banner = banner,
                onClick = { onBannerClick(banner) },
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(Modifier.height(10.dp))

        DotsIndicator(
            totalDots = banners.size,
            selectedIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth()
        )
    }
}