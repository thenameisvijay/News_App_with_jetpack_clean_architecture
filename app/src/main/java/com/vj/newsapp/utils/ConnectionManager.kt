package com.vj.newsapp.utils

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */

@Singleton
class ConnectionManager @Inject constructor(application: Application) {

    private val connectionLiveData = ConnectionListener(application)
    val isNetworkAvailable = MutableLiveData(false)

    fun registerConnectionObserver(lifecycleOwner: LifecycleOwner){
        connectionLiveData.observe(lifecycleOwner) { isConnected ->
            isConnected?.let { isNetworkAvailable.value = it }
        }
    }

    fun unregisterConnectionObserver(lifecycleOwner: LifecycleOwner){
        connectionLiveData.removeObservers(lifecycleOwner)
    }
}