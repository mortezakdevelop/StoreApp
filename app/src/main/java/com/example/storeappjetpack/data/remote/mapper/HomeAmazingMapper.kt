package com.example.storeappjetpack.data.remote.mapper

import com.example.storeappjetpack.data.remote.dto.HomeAmazingDtoItem
import com.example.storeappjetpack.domain.model.HomeAmazingModel


fun HomeAmazingDtoItem.toAmazingDomain(): HomeAmazingModel =
    HomeAmazingModel(
        amazingPrice = amazingPrice,
        amazingTime = amazingTime,
        id = id,
        image = image,
        number = number,
        name = name,
        offPercent = offPercent,
        price = price,
        sellsCount = sellsCount
    )