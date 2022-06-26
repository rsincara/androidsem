package com.zotreex.sample_project.domain.usecases.getProductItem

import com.zotreex.sample_project.domain.data.Product

interface GetProductItemUseCase {
    suspend operator fun invoke(id: Int): Product
}