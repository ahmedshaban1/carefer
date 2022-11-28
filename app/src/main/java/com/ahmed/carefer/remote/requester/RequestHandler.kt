package com.ahmed.carefer.remote.requester

import com.ahmed.carefer.remote.utilities.ResultWrapper

interface RequestHandler {
    suspend fun <T> makeApiRequest(
        call: suspend () -> T?
    ): ResultWrapper<T>
}
