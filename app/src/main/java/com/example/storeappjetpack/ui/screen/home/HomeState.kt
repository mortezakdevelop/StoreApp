package com.example.storeappjetpack.ui.screen.home

import com.example.storeappjetpack.domain.model.BannerModel

data class HomeState(
    val isLoading: Boolean = false,
    val banners: List<BannerModel> = emptyList(),
    val errorText: String? = null
)
