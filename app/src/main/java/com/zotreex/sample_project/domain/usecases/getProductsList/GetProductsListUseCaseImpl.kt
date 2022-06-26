package com.zotreex.sample_project.domain.usecases.getProductsList

import com.zotreex.sample_project.domain.data.Product
import com.zotreex.sample_project.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductsListUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductsListUseCase {
    override suspend fun invoke(): List<Product> = productRepository.getProductsList()
}