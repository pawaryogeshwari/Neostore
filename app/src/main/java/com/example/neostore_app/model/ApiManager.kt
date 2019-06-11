package com.example.neostore_app.model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager {
    companion object {

        fun getClient(): Retrofit {
           // val interceptor = HttpLoggingInterceptor()
           // interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .baseUrl("http://staging.php-dev.in:8844/trainingapp/api/users/")
                .addConverterFactory(GsonConverterFactory.create()).client(client)
                .build()

            return retrofit

        }
    }
}
