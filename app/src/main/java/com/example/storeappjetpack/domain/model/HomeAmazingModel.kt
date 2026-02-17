package com.example.storeappjetpack.domain.model

import com.google.gson.annotations.SerializedName

data class HomeAmazingModel(
    val amazingPrice: Int,
    val amazingTime: Long,
    val id: Int,
    val image: String,
    val name: String,
    val number: Int,
    val offPercent: Int,
    val price: Int,
    val sellsCount: Int
)
