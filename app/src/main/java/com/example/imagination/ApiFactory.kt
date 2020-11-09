package com.example.imagination

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    private const val ENDPOINT = "http://www.omdbapi.com/"

    fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getApiService() =
        getRetrofit().create(ApiService::class.java)
}