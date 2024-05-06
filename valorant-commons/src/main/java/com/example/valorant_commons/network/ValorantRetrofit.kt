package com.example.valorant_commons.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ValorantRetrofit {
    private val BASE_URL = "https://valorant-api.com/"

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}