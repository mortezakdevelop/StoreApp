package com.example.storeappjetpack.data.remote.dto

import com.example.storeappjetpack.domain.model.BannerModel

data class BannerDto(
    val id: Int,
    val image: String,
    val type: String,
    val link: String
)

