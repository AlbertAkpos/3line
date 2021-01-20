package me.alberto.a3line.util.helper

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class NetworkHelper @Inject constructor(private val context: Context) {
    fun isConnected(): Boolean {
        val connectionManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectionManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}