package com.example.neostore_app.network

import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import com.example.neostore_app.model.LoginResponse
import retrofit2.Callback

class APIRetrofit {

    fun userLogin(email: String, password: String,callback:Callback<LoginResponse>) {
        val apiManager = ApiManager.getClient().create(Api::class.java)
            .userLogin(email, password)

        apiManager.enqueue(callback)

    }

    fun userCreate(first_name:String,last_name:String,email: String,password: String,confirm_password:String,phone_no:Number,gender:String,callback: Callback<LoginResponse>)
    {
        val apiManager=ApiManager.getClient().create(Api::class.java)
            .userCreate(first_name,last_name,email, password, confirm_password, phone_no, gender)
        apiManager.enqueue(callback)
    }
}