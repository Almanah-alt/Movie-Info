package com.example.imagination

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataLoader (
    private val onSuccess: (Result) -> Unit,
    private val onError: (Throwable) -> Unit,
    private val t: String,
    private val apikey: String
) {

    fun loadData() {
        ApiFactory.getApiService()
            .getVideoByTitle(t, apikey)
            .enqueue(object : Callback<Result> {
                override fun onResponse(
                    call: Call<Result>,
                    response: Response<Result>
                ) {
                    Log.d("taaaaaag", "$response")
                    onSuccess(response.body()!!)
                }

                override fun onFailure(call: Call<Result>, t: Throwable) {
                    onError(t)
                }
            })
    }
}