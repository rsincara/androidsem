package com.zotreex.sample_project.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.SettingsFragmentBinding
import com.zotreex.sample_project.di.ViewModelFactory
import com.zotreex.sample_project.di.appComponent
import com.zotreex.sample_project.state.Theme
import javax.inject.Inject

class SettingsFragment : Fragment(R.layout.settings_fragment) {
    lateinit var thisContext: Context

    private val binding: SettingsFragmentBinding by viewBinding()

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        this.thisContext = context
        super.onAttach(context)
    }

    private fun chooseThemeDialog() {

        val builder = AlertDialog.Builder(thisContext)
        builder.setTitle("Choose theme")
        val styles = arrayOf("Light","Dark")
        val checkedItem = Theme.currentTheme

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->
            when (which) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    dialog.dismiss()
                    Theme.currentTheme = 0
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    dialog.dismiss()
                    Theme.currentTheme = 1
                }
            }
        }

        val dialog = builder.create()
        dialog.show()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.themeButton.setOnClickListener { chooseThemeDialog() }
    }

}