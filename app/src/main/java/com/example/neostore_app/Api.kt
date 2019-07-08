package com.example.neostore_app

import com.example.neostore_app.Product.ProductResponse
import com.example.neostore_app.model.LoginResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @FormUrlEncoded
    @POST("api/users/register")
fun userCreate(
        @Field("first_name")first_name:String,
        @Field("last_name")last_name:String,
        @Field("email")email: String,
        @Field("password")password: String,
        @Field("confirm_password")confirm_password:String,
        @Field("phone_no")phone_no:Number,
        @Field("gender")gender:String
    ):Call<LoginResponse>


    @FormUrlEncoded
    @POST("api/users/login")
     fun userLogin(

        @Field("email")  email:String,
        @Field("password") password:String
    ): Observable<LoginResponse>

@FormUrlEncoded
@GET("api/products/getList")
fun productDetails(
    @Query("product_category_id")product_category_id:String,
    @Query("limit")limit:Number,
    @Query("page")page:Number


):Call<ProductResponse>

}