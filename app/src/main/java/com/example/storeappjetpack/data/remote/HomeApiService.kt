package com.example.storeappjetpack.data.remote

import com.example.storeappjetpack.data.dto.BannerDto
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiService {

    @GET("/s/newshop/home/banners.php")
    suspend fun getBanner(): List<BannerDto>
}