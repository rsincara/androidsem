package com.zotreex.sample_project.domain.usecases.getProductItem

import com.zotreex.sample_project.domain.data.Product
import com.zotreex.sample_project.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductItemUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductItemUseCase {
    override suspend fun invoke(id: Int): Product = productRepository.getProductItem(id)
}