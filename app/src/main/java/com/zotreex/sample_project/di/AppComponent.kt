package com.zotreex.sample_project.di

import com.zotreex.sample_project.ui.ProductCardFragment
import com.zotreex.sample_project.ui.ProductListFragment
import com.zotreex.sample_project.ui.SearchFragment
import com.zotreex.sample_project.ui.SettingsFragment
import dagger.Component
import dagger.Module

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(fragment: ProductListFragment)
    fun inject(fragment: ProductCardFragment)
    fun inject(fragment: SettingsFragment)
    fun inject(fragment: SearchFragment)

    fun viewModelFactory() : ViewModelFactory
}

@Module(includes = [NetworkModule::class, AppBindModule::class, ViewModelModule::class])
class AppModule
