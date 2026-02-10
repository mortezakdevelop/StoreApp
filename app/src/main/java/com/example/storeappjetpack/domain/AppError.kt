package com.example.storeappjetpack.domain

sealed interface AppError {
    data object Network : AppError          // مثل No internet
    data object Timeout : AppError
    data class Http(val code: Int) : AppError
    data object Parsing : AppError
    data class Unknown(val throwable: Throwable) : AppError
}