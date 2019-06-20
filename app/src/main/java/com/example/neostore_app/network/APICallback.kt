package com.example.neostore_app.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class APICallback<T>() : Callback<T> {
    override fun onFailure(call: Call<T>, t: Throwable) {

        onFailure(t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {

            response(response.code(), response.body())
    }

    open fun response(status: Int, response: T?) {


    }

    open fun onFailure(t: Throwable) {

    }



}
