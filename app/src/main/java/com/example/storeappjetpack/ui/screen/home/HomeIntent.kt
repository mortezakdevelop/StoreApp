package com.example.storeappjetpack.ui.screen.home

import com.example.storeappjetpack.domain.model.BannerModel

sealed interface HomeIntent {
    data class OnBannerClick(val banner: BannerModel) : HomeIntent
    data class OnSearchQueryChange(val query: String) : HomeIntent
    data object OnSearchSubmit : HomeIntent // اختیاری
}