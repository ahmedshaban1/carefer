package com.ahmed.carefer.remote.utilities

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(val errorCode: Int, val extra: List<String> = listOf()) : ResultWrapper<Nothing>()
}
