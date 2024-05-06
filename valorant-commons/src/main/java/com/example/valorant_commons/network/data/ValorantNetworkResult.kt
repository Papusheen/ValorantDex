package com.example.valorant_commons.network.data

sealed class ValorantNetworkResult<T>(
    val data: T? = null,
    val status: Int? = null,
    val message: String? = null
) {

    class SuccessStatus<T>(data: T) : ValorantNetworkResult<T>(data)

    class ErrorStatus<T>(status: Int? = 0, message: String?, data: T? = null) : ValorantNetworkResult<T>(data, status, message)

    class LoadingStatus<T> : ValorantNetworkResult<T>()

}