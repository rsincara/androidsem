package com.zotreex.sample_project.domain.api

import com.zotreex.sample_project.domain.data.Product
import retrofit2.http.GET
import retrofit2.http.Query

interface SampleService {
    //todo ОБЕРНУТЬ в НЕКИЙ ApiResult с перехватом try catch
    @GET("products")
    suspend fun getProductsList(): List<Product>

    @GET("products/{id}")
    suspend fun getProductItem(@Query("id") id: Int): Product
}