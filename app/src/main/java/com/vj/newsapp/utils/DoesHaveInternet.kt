package com.vj.newsapp.utils

import android.util.Log
import java.io.IOException
import java.net.InetSocketAddress
import javax.net.SocketFactory

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */

private const val TAG = "DoesHaveInternet"

object DoesHaveInternet {
    fun execute(socketFactory: SocketFactory): Boolean {
        return try {
            Log.i(TAG, "Pinging")
            val socket = socketFactory.createSocket() ?: throw IOException("Socket is null")
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            Log.i(TAG, "Success!")
            true
        } catch (ioe: IOException) {
            Log.i(TAG, "execute: No Internet Connection! $ioe")
            false
        }
    }
}