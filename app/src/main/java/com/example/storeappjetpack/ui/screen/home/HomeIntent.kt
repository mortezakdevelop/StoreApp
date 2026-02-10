package com.example.storeappjetpack.ui.screen.home

import com.example.storeappjetpack.domain.model.BannerModel

sealed interface HomeIntent {
    data object Load : HomeIntent
    data object Retry : HomeIntent
    data class OnBannerClick(val banner: BannerModel) : HomeIntent
}