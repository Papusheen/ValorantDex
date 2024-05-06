package com.example.valorant_commons.network.data.models

data class ValorantResponse<T>(
    val status: Int,
    val data: T?
)