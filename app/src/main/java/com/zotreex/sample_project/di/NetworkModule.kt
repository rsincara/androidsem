package com.zotreex.sample_project.di

import com.zotreex.sample_project.domain.api.ProductService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


@Module
class NetworkModule {
    @Provides
    fun provideSampleApi(): ProductService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://fakestoreapi.com/")
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build()
            )
            .build()
        return retrofit.create()
    }
}