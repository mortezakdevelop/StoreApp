package com.example.storeappjetpack.data.di

import android.content.Context
import android.os.Debug
import com.example.storeappjetpack.ui.core.NetworkChecker
import com.example.storeappjetpack.ui.core.NetworkCheckerImpl
import com.example.storeappjetpack.ui.utils.Constants.BASE_URL
import com.example.storeappjetpack.ui.utils.Constants.TIMEOUT_IN_SECOND
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StoreModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY

        }

    @Provides
    @Singleton
    fun provideOkHttp(logging: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_IN_SECOND, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_IN_SECOND, TimeUnit.SECONDS)

            //TODO Just DEBUG mode logging interceptor
            .apply {
                addInterceptor(logging)
            }

            .build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideNetworkChecker(
        @ApplicationContext context: Context
    ): NetworkChecker = NetworkCheckerImpl(context)


}