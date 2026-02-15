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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeappjetpack.domain.model.BannerModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlin.coroutines.cancellation.CancellationException

@Composable
fun BannerSliderInfiniteScroll(
    banners: List<BannerModel>,
    onBannerClick: (BannerModel) -> Unit,
    modifier: Modifier = Modifier,
    autoScrollDelayMs: Long = 3000L
) {
    if (banners.isEmpty()) return

    // Start on middle of dots(for easy infinite scroll)
    val startIndex = remember(banners.size) {
        val mid = Int.MAX_VALUE / 2
        mid - (mid % banners.size)
    }

    val pagerState = rememberPagerState(
        initialPage = startIndex,
        pageCount = { Int.MAX_VALUE }
    )

    val currentRealIndex = (pagerState.currentPage % banners.size)

    LaunchedEffect(pagerState, banners.size, autoScrollDelayMs) {
        if (banners.size <= 1) return@LaunchedEffect

        while (isActive) {
            // اگر کاربر داره اسکرول می‌کنه، صبر کن تا تموم بشه
            while (pagerState.isScrollInProgress && isActive) {
                delay(100)
            }

            // بعد از اینکه کاربر ول کرد، یه مکث کوتاه برای UX بهتر
            delay(autoScrollDelayMs)

            // دوباره چک کن شاید کاربر وسط delay دوباره اسکرول کرد
            if (pagerState.isScrollInProgress) continue

            try {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            } catch (_: CancellationException) {

            }
        }
    }

    Column(modifier = modifier.fillMaxWidth()) {

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 12.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) { page ->
            val banner = banners[page % banners.size]
            GlideBannerItem(
                banner = banner,
                onClick = { onBannerClick(banner) },
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(Modifier.height(10.dp))

        if (banners.size > 1) {
            DotsIndicator(
                totalDots = banners.size,
                selectedIndex = currentRealIndex,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}