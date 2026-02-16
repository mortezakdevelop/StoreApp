package com.example.storeappjetpack.domain.repository

import com.example.storeappjetpack.domain.ResponseResult
import com.example.storeappjetpack.domain.model.BannerModel
import com.example.storeappjetpack.domain.model.HomeCategoryModel

interface HomeRepository {
    suspend fun getBanner(): ResponseResult<List<BannerModel>>

    suspend fun getHomeCategory(): ResponseResult<List<HomeCategoryModel>>
}