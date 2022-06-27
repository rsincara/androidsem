package com.zotreex.sample_project.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.squareup.picasso.Picasso
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.ActivityProductItemBinding
import com.zotreex.sample_project.di.ViewModelFactory
import com.zotreex.sample_project.di.appComponent
import com.zotreex.sample_project.domain.data.UiState
import javax.inject.Inject

class ProductCardFragment : Fragment(R.layout.activity_product_item) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<ProductViewModel> { viewModelFactory }
    private val binding: ActivityProductItemBinding by viewBinding()

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productId = arguments?.getInt("id")
        if (productId != null) {
            viewModel.getProduct(productId)
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            it ?: return@observe
            if (it is UiState.Loading)
                binding.progress.visibility = View.VISIBLE
            else
                binding.progress.visibility = View.GONE

            if(it is UiState.Success) {
                print("success!")
                val product = it.value
                binding.title.text = product.title
                binding.desc.text = product.description
                binding.price.text = product.price.toString() + "$"
                binding.categoryValue.text = product.category
                Picasso.get().load(product.image).into(binding.cardImg)
            }
        }
    }

}