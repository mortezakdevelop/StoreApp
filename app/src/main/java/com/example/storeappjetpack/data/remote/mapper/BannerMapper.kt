package com.example.storeappjetpack.data.remote.mapper

import com.example.storeappjetpack.data.remote.dto.BannerDto
import com.example.storeappjetpack.domain.model.BannerModel

fun BannerDto.toDomain(): BannerModel =
    BannerModel(
        id = id,
        imageUrl = image,
        type = type,
        link = link
    )


