package com.zotreex.sample_project.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.SearchFragmentBinding

class SearchFragment : Fragment(R.layout.search_fragment) {
    private val binding: SearchFragmentBinding by viewBinding()

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