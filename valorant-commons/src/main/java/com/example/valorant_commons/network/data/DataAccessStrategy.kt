package com.example.valorant_commons.network.data

import android.util.Log

class DataAccessStrategy {
    suspend fun <T, A> performGetOperation(
        databaseQuery: suspend () -> T,
        databaseQueryOnError: suspend () -> T,
        networkCall: suspend () -> ValorantNetworkResult<A>,
        saveCallResult: suspend (A) -> Unit
    ): ValorantNetworkResult<T> {
        return try {
            when (val networkResult = networkCall.invoke()) {
                is ValorantNetworkResult.SuccessStatus -> {
                    networkResult.data?.let { saveCallResult(it) }
                    val data = databaseQuery.invoke()
                    ValorantNetworkResult.SuccessStatus(data)
                }

                is ValorantNetworkResult.ErrorStatus -> {
                    networkResult.message?.let { Log.e("Error call", it) }
                    val data = databaseQueryOnError.invoke()
                    ValorantNetworkResult.SuccessStatus(data)
                }

                else -> throw IllegalStateException("Unexpected network result type")
            }
        } catch (e: Exception) {
            val data = databaseQueryOnError.invoke()
            ValorantNetworkResult.SuccessStatus(data)
        }
    }
}