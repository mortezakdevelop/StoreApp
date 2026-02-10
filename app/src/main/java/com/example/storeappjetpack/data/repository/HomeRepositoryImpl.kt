package com.example.storeappjetpack.data.repository

import com.example.storeappjetpack.data.dto.toDomain
import com.example.storeappjetpack.data.remote.HomeApiService
import com.example.storeappjetpack.domain.AppError
import com.example.storeappjetpack.domain.ResponseResult
import com.example.storeappjetpack.domain.model.BannerModel
import com.example.storeappjetpack.domain.repository.HomeRepository
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApiService: HomeApiService
) : HomeRepository {

    override suspend fun getBanner(): ResponseResult<List<BannerModel>> {
        return try {
            val data = homeApiService.getBanner().map { it.toDomain() }
            ResponseResult.Success(data)
        } catch (e: Exception) {
            ResponseResult.Error(e.toAppError())
        }
    }
}

private fun Exception.toAppError(): AppError = when (this) {
    is SocketTimeoutException -> AppError.Timeout
    is IOException -> AppError.Network
    is HttpException -> AppError.Http(code())
    is com.google.gson.JsonParseException -> AppError.Parsing
    else -> AppError.Unknown(this)
}