package com.m2lifeapps.cryptocurrenywithcompose.common

sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)

    class Error<T>(error: String, data: T? = null) : Resource<T>(data, error)

    class Loading<T>(data: T? = null) : Resource<T>(data)
}
