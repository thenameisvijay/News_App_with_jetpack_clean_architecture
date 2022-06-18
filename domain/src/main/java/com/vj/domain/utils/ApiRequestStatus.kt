package com.vj.domain.utils

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
sealed class ApiRequestStatus<out T> {
    class Success<out R>(val response: R) : ApiRequestStatus<R>()
    class Failed(
        message: String?,
        throwable: Throwable? = null
    ) : ApiRequestStatus<Nothing>()
}
