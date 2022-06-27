package com.zotreex.sample_project.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.SettingsFragmentBinding
import com.zotreex.sample_project.di.appComponent

class SearchFragment : Fragment(R.layout.search_fragment) {
    lateinit var thisContext: Context

    private val binding: SettingsFragmentBinding by viewBinding()

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        this.thisContext = context
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}