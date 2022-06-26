package com.zotreex.sample_project.domain.repository

import com.zotreex.sample_project.domain.data.Product

interface ProductRepository {
    suspend fun getProductsList(): List<Product>

    suspend fun getProductItem(id: Int): Product
}