package com.zotreex.sample_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zotreex.sample_project.domain.data.Product
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.domain.usecases.getProductsList.GetProductsListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val getProductsListUseCase: GetProductsListUseCase
) : ViewModel() {
    val liveData = MutableLiveData<UiState<List<Product>>>(UiState.Loading)

    init {
        viewModelScope.launch {
            val list = getProductsListUseCase()
            liveData.postValue(UiState.Success(list))
        }
    }

    fun setLive() {
        val list = listOf(
            Product(id = 1, title = "test1", price=10.1, category="test", description="test desc", image="test" ),
        )
        liveData.postValue(UiState.Success(list))
    }
}