package com.zotreex.sample_project.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.FragmentProductsListBinding
import com.zotreex.sample_project.di.ViewModelFactory
import com.zotreex.sample_project.di.appComponent
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.ui.adapters.ProductsListAdapter
import javax.inject.Inject

class ProductListFragment : Fragment(R.layout.fragment_products_list) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<ProductsViewModel> { viewModelFactory }
    private val binding: FragmentProductsListBinding by viewBinding()
    private val adapter = ProductsListAdapter()

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sampleAdapter.adapter = adapter
        binding.sampleAdapter.layoutManager = GridLayoutManager(context, 2)

        viewModel.liveData.observe(viewLifecycleOwner) {
            it ?: return@observe
            if (it is UiState.Loading)
                binding.progress.visibility = View.VISIBLE
            else
                binding.progress.visibility = View.GONE

            if(it is UiState.Success)
                adapter.submitList(it.value)
        }
    }

}