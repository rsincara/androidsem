package com.zotreex.sample_project.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zotreex.sample_project.ui.ProductViewModel
import com.zotreex.sample_project.ui.ProductsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel::class)
    abstract fun sampleViewModel(productsViewModel: ProductsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    abstract fun productViewModel(productViewModel: ProductViewModel): ViewModel

}