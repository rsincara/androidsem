package com.zotreex.sample_project

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zotreex.sample_project.databinding.ActivityMainBinding
import com.zotreex.sample_project.services.Connection

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewBinding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isOnline = Connection.isOnline(this)

        val bottomNavigationView = viewBinding.navView

        if (!isOnline) {
            bottomNavigationView.visibility = View.GONE
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnItemSelectedListener{
            navController.navigate(it.itemId)
            return@setOnItemSelectedListener true
        }

        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
            print("Not found actionbar")
        }
    }
}