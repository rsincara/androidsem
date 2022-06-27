package com.zotreex.sample_project.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.zotreex.sample_project.R
import com.zotreex.sample_project.services.Connection

class ConnectionFragment : Fragment(R.layout.connection_fragment){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val isOnline = context?.let { Connection.isOnline(it) }
        if (isOnline == true) {
            Navigation.findNavController(view).navigate(
                R.id.action_connectionFragment_to_productListFragment,
            )
        }
    }
}