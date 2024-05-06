package com.example.valorant_commons.network.data

import android.util.Log
import com.example.valorant_commons.network.data.models.ValorantResponse

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> ValorantResponse<T>): ValorantNetworkResult<T> {
        try {
            val response = call()
            if (response.status == 200) {
                val body = response.data
                if (body != null) return ValorantNetworkResult.SuccessStatus(body)
            }
            return ValorantNetworkResult.ErrorStatus(response.status, response.data.toString())
        } catch (e: Exception) {
            return ValorantNetworkResult.ErrorStatus(message = e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): ValorantNetworkResult<T> {
        Log.e("remoteDataSource", message)
        return ValorantNetworkResult.ErrorStatus(message = "Network call has failed for a following reason: $message")
    }

}