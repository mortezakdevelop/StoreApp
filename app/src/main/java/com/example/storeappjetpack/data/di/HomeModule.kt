package com.example.storeappjetpack.data.di

import com.example.storeappjetpack.data.remote.HomeApiService
import com.example.storeappjetpack.data.repository.HomeRepositoryImpl
import com.example.storeappjetpack.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideBannerApi(retrofit: Retrofit): HomeApiService =
        retrofit.create(HomeApiService::class.java)

    @Provides
    @Singleton
    fun provideHomeRepository(homeApiService: HomeApiService): HomeRepository =
        HomeRepositoryImpl(homeApiService)
}