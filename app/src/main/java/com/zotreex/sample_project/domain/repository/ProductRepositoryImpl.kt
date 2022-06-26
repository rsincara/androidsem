package com.zotreex.sample_project.domain.repository

import com.zotreex.sample_project.domain.api.ProductService
import com.zotreex.sample_project.domain.data.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productService: ProductService
) : ProductRepository {
    override suspend fun getProductsList(): List<Product> = productService.getProductsList()

    override suspend fun getProductItem(id: Int): Product = productService.getProductItem(id)
}