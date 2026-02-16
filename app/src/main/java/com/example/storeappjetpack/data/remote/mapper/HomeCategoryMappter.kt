package com.example.storeappjetpack.data.remote.mapper

import com.example.storeappjetpack.data.remote.dto.HomeCategoryDtoItem
import com.example.storeappjetpack.domain.model.HomeCategoryModel

fun HomeCategoryDtoItem.homeCategoryToDomain(): HomeCategoryModel =
    HomeCategoryModel(
        id = id,
        image = image,
        title = title
    )