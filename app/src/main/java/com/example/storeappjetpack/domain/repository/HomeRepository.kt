package com.example.storeappjetpack.domain.repository

import com.example.storeappjetpack.domain.ResponseResult
import com.example.storeappjetpack.domain.model.BannerModel

interface HomeRepository {
    suspend fun getBanner(): ResponseResult<List<BannerModel>>
}