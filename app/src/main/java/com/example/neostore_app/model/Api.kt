package com.example.neostore_app.model

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("api/users/register")
fun userCreate(
        @Field("first_name")first_name:String,
        @Field("last_name")last_name:String,
        @Field("email")email: String,
        @Field("password")password: String,
        @Field("confirm_password")confirm_password:String,
        @Field("phone_no")phone_no:Number
    ):Call<LoginResponse>




    @FormUrlEncoded
    @POST("api/users/login")
     fun userLogin(

        @Field("email")  email:String,
        @Field("password") password:String
    ):Call<LoginResponse>
}