package com.example.storeappjetpack.data.remote

import com.example.storeappjetpack.data.remote.dto.BannerDto
import retrofit2.http.GET

interface HomeApiService {

    @GET("/s/newshop/home/banners.php")
    suspend fun getBanner(): List<BannerDto>
}