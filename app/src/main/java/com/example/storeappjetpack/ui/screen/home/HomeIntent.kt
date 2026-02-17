package com.example.storeappjetpack.ui.screen.home

import com.example.storeappjetpack.domain.model.BannerModel
import com.example.storeappjetpack.domain.model.HomeAmazingModel
import com.example.storeappjetpack.domain.model.HomeCategoryModel

sealed interface HomeIntent {
    data class OnBannerClick(val banner: BannerModel) : HomeIntent
    data class OnCategoryClick(val category: HomeCategoryModel) : HomeIntent
    data class OnAmazingClick(val id: Int): HomeIntent
    data class OnSearchQueryChange(val query: String) : HomeIntent
    data object OnSearchSubmit : HomeIntent
}