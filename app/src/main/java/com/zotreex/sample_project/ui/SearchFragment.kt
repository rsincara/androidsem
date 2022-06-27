package com.zotreex.sample_project.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.SearchFragmentBinding
import com.zotreex.sample_project.databinding.SettingsFragmentBinding
import com.zotreex.sample_project.di.ViewModelFactory
import com.zotreex.sample_project.di.appComponent
import javax.inject.Inject

class SearchFragment : Fragment(R.layout.search_fragment) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<ProductViewModel> { viewModelFactory }
    private val binding: SearchFragmentBinding by viewBinding()

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchButton.setOnClickListener {
            val text = binding.searchInput.text.toString()

            Navigation.findNavController(it).navigate(
                R.id.action_searchFragment_to_productListFragment,
                bundleOf(Pair("search", text))
            )
        }
    }

}