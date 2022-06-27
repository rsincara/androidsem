package com.zotreex.sample_project.services

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class Connection {
    companion object {
        fun isOnline(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }
}