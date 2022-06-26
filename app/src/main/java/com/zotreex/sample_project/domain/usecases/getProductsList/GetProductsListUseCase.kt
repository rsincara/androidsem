package com.zotreex.sample_project.domain.usecases.getProductsList

import com.zotreex.sample_project.domain.data.Product

interface GetProductsListUseCase {
    suspend operator fun invoke(): List<Product>
}