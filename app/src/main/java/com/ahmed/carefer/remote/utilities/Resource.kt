package com.ahmed.carefer.remote.utilities

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    class Error(val errorCode: Int) : Resource<Nothing>()
    class Success<out T>(val data: T?, val dataSource: DataSource = DataSource.REMOTE) : Resource<T>()
}

enum class DataSource {
    CACHE, REMOTE
}
