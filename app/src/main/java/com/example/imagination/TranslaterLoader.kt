package com.example.imagination

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TranslaterLoader (
    private val onSuccess: (Translation) -> Unit,
    private val onError: (Throwable) -> Unit,
    private val text: String,
    private val lang_from: String,
    private val lang_to: String
) {

    fun loadData() {
        ApiFactoryTranslate.getApiServiceTranslate()
            .getTranslation(text, lang_from, lang_to)
            .enqueue(object : Callback<Translation> {
                override fun onResponse(
                    call: Call<Translation>,
                    response: Response<Translation>
                ) {
                    onSuccess(response.body()!!)
                }

                override fun onFailure(call: Call<Translation>, t: Throwable) {
                    onError(t)
                }
            })
    }
}