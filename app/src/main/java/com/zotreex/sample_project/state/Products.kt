package com.zotreex.sample_project.state

import com.zotreex.sample_project.domain.data.Product

class Products {
    companion object {
        lateinit var products: List<Product>
        lateinit var currentProduct: Product
    }
}