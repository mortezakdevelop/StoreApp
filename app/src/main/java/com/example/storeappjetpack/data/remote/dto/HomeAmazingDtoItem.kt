package com.example.storeappjetpack.data.remote.dto

import com.google.gson.annotations.SerializedName

data class HomeAmazingDtoItem(
    @SerializedName("amazing_price")
    val amazingPrice: Int,
    @SerializedName("amazing_time")
    val amazingTime: Long,
    val id: Int,
    val image: String,
    val name: String,
    val number: Int,
    @SerializedName("off_percent")
    val offPercent: Int,
    val price: Int,
    @SerializedName("sells_count")
    val sellsCount: Int
)