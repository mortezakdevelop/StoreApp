package com.example.storeappjetpack.data.remote

import com.example.storeappjetpack.data.remote.dto.BannerDto
import com.example.storeappjetpack.data.remote.dto.HomeCategoryDtoItem
import retrofit2.http.GET

interface HomeApiService {

    @GET("/s/newshop/home/banners.php")
    suspend fun getBanner(): List<BannerDto>

    @GET("/s/newshop/home/general_cat.php")
    suspend fun getHomeCategory():List<HomeCategoryDtoItem>
}