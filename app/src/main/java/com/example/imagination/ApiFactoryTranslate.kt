package com.example.imagination

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.create
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory.create
import java.lang.StringBuilder
import java.net.URI.create


object ApiFactoryTranslate {
    private const val ENDPOINT_TRANSLATOR = "https://just-translated.p.rapidapi.com/"

    var gson = GsonBuilder()
        .setLenient()
        .create()


    fun getRetrofitTranslate() =
        Retrofit.Builder()
            .baseUrl(ENDPOINT_TRANSLATOR)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    fun getApiServiceTranslate() =
        getRetrofitTranslate().create(ApiServiceTranslator::class.java)
}