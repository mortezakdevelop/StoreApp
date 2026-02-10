package com.example.storeappjetpack.domain.usecase

import com.example.storeappjetpack.domain.ResponseResult
import com.example.storeappjetpack.domain.model.BannerModel
import com.example.storeappjetpack.domain.repository.HomeRepository
import javax.inject.Inject

class GetBannerHomeUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): ResponseResult<List<BannerModel>> = repository.getBanner()
}