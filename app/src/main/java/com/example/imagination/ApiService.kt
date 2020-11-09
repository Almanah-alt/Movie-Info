package com.example.imagination


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET(".")
    fun getVideoByTitle(@Query("t") title: String, @Query("apikey") apikey: String): Call<Result>

    @GET(".")
    fun getVideoById(@Query("i") id: String): Call<Result>


}