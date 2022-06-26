package com.zotreex.sample_project.di

import com.zotreex.sample_project.domain.repository.ProductRepository
import com.zotreex.sample_project.domain.repository.ProductRepositoryImpl
import com.zotreex.sample_project.domain.usecases.getProductItem.GetProductItemUseCase
import com.zotreex.sample_project.domain.usecases.getProductItem.GetProductItemUseCaseImpl
import com.zotreex.sample_project.domain.usecases.getProductsList.GetProductsListUseCase
import com.zotreex.sample_project.domain.usecases.getProductsList.GetProductsListUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {
    @Binds
    fun bindSampleRepository(repository: ProductRepositoryImpl): ProductRepository

    @Binds
    fun bindGetSampleListUseCase(useCase: GetProductsListUseCaseImpl): GetProductsListUseCase

    @Binds
    fun bindGetSampleItemUseCase(useCase: GetProductItemUseCaseImpl): GetProductItemUseCase
}