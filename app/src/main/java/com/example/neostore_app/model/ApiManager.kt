package com.example.neostore_app.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager {
    companion object {

        fun getClient(): Retrofit {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            return Retrofit.Builder()
                .baseUrl("http://staging.php-dev.in:8844/trainingapp/")

                .addConverterFactory(GsonConverterFactory.create()).client(client)
                .build()

        }
    }
}
