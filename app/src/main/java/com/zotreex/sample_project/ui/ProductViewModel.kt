package com.zotreex.sample_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zotreex.sample_project.domain.data.Product
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.domain.usecases.getProductItem.GetProductItemUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val getProductItemUseCase: GetProductItemUseCase,
) : ViewModel() {
    val liveData = MutableLiveData<UiState<Product>>(UiState.Loading)

    fun getProduct(id: Int) {
        print("TEST!")

        viewModelScope.launch {
   //         val product = getProductItemUseCase(id)
            val product = Product(id = id, title="Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", price=105.90, category="men's clothing",
                description="Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday", image="https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg")
            liveData.postValue(UiState.Success(product))
        }
    }

//    init {
//        viewModelScope.launch {
//            val product = getProductItemUseCase(5)
//            liveData.postValue(UiState.Success(product))
//        }
//    }
}