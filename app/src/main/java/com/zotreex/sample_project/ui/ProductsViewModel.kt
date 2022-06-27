package com.zotreex.sample_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zotreex.sample_project.domain.data.Product
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.domain.usecases.getProductsList.GetProductsListUseCase
import com.zotreex.sample_project.state.Products
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductsViewModel @Inject constructor(
    private val getProductsListUseCase: GetProductsListUseCase
) : ViewModel() {
    val liveData = MutableLiveData<UiState<List<Product>>>(UiState.Loading)

    fun search(text: String): List<Product> {
        val productsList = Products.products

        if (productsList != null) {
            return productsList.filter {
                it.description.lowercase().contains(text) ||
                        it.title.lowercase().contains(text)
            }
        } else {
            return listOf()
        }
    }

    init {
        viewModelScope.launch {
            val isCacheListEmpty = Products.products == null
            if (isCacheListEmpty) {
                val list = getProductsListUseCase()
                Products.products = list
                liveData.postValue(UiState.Success(list))
            } else {
                liveData.postValue(UiState.Success(Products.products ?: listOf()))
            }
        }
    }
}