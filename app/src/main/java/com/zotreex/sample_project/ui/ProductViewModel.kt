package com.zotreex.sample_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zotreex.sample_project.domain.data.Product
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.domain.usecases.getProductItem.GetProductItemUseCase
import com.zotreex.sample_project.state.Products
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val getProductItemUseCase: GetProductItemUseCase,
) : ViewModel() {
    val liveData = MutableLiveData<UiState<Product>>(UiState.Loading)

    fun getProduct(id: Int) {
        viewModelScope.launch {
            val product = Products.currentProduct
            liveData.postValue(UiState.Success(product))
        }
    }
}