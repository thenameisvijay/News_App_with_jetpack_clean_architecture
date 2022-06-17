package com.vj.newsapp.utils

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
sealed class ApiRequestStatus<out T> {
    class Success<out R>(val response: R) : ApiRequestStatus<R>()
    class Failed(
        val message: String?,
        val throwable: Throwable?
    ) : ApiRequestStatus<Nothing>()
}
