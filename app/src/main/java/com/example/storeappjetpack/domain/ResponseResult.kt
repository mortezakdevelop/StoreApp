package com.example.storeappjetpack.domain

sealed interface ResponseResult<out T> {
    data class Success<T>(val data: T) : ResponseResult<T>
    data class Error(val error: AppError) : ResponseResult<Nothing>
}
