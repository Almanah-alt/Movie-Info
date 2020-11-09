package com.example.imagination


import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiServiceTranslator {

    @Headers("x-rapidapi-key: 98658dca60msh2ef9162625d5876p1453ffjsn56c9e6b984aa",
            "Content-Type: application/x-www-form-urlencoded",
             "x-rapidapi-host: just-translated.p.rapidapi.com")
    @GET(".")
    fun getTranslation(@Query("text") text: String, @Query("lang_from") lang_from: String, @Query("lang_to") lang_to: String): Call<Translation>


}