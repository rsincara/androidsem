package com.zotreex.sample_project.state

import com.zotreex.sample_project.domain.data.Product

class Products {
    companion object {
        var products: List<Product>? = null
        lateinit var currentProduct: Product
    }
}