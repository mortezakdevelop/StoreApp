package com.example.storeappjetpack.data.dto

import com.example.storeappjetpack.domain.model.BannerModel

data class BannerDto(
    val id: Int,
    val image: String,
    val type: String,
    val link: String
)

fun BannerDto.toDomain(): BannerModel =
    BannerModel(
        id = id,
        imageUrl = image,
        type = type,
        link = link
    )