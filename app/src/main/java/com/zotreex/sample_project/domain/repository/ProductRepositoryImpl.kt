package com.zotreex.sample_project.domain.repository

import com.zotreex.sample_project.domain.api.SampleService
import com.zotreex.sample_project.domain.data.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val sampleService: SampleService
) : ProductRepository {
    override suspend fun getProductsList(): List<Product> = sampleService.getProductsList()

    override suspend fun getProductItem(id: Int): Product = sampleService.getProductItem(id)
}