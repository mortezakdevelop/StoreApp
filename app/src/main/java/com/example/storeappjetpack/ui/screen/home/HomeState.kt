package com.example.storeappjetpack.ui.screen.home

import com.example.storeappjetpack.domain.model.BannerModel
import com.example.storeappjetpack.domain.model.HomeAmazingModel
import com.example.storeappjetpack.domain.model.HomeCategoryModel

data class HomeState(
    val isLoading: Boolean = false,
    val banners: List<BannerModel> = emptyList(),
    val category: List<HomeCategoryModel> = emptyList(),
    val amazing: List<HomeAmazingModel> = emptyList(),
    val isCategoryLoading:Boolean = false,
    val isAmazingLoading:Boolean = false,
    val categoriesError:String? = null,
    val errorText: String? = null,
    val querySearch:String = ""
)
