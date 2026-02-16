package com.example.storeappjetpack.domain.usecase

import com.example.storeappjetpack.domain.ResponseResult
import com.example.storeappjetpack.domain.model.HomeCategoryModel
import com.example.storeappjetpack.domain.repository.HomeRepository
import javax.inject.Inject

class GetHomeCategoryUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend operator fun invoke(): ResponseResult<List<HomeCategoryModel>> = homeRepository.getHomeCategory()
}