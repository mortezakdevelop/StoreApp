package com.example.storeappjetpack.domain.repository

import com.example.storeappjetpack.domain.ResponseResult
import com.example.storeappjetpack.domain.model.BannerModel
import javax.inject.Inject

interface HomeRepository {
    suspend fun getBanner(): ResponseResult<List<BannerModel>>
}