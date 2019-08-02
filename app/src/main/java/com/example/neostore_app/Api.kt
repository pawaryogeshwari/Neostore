package com.example.neostore_app

import com.example.neostore_app.AddressListening.OrderResponse
import com.example.neostore_app.EditProfile.EditDataResponse
import com.example.neostore_app.Product.ProductResponse
import com.example.neostore_app.Login.LoginResponse
import com.example.neostore_app.Myaccount.UserData
import com.example.neostore_app.Myaccount.UserResponse
import com.example.neostore_app.ProductDetail.ProductDetailResponse
import com.example.neostore_app.Rating.AddCartResponse
import com.example.neostore_app.Rating.RatingResponse
import com.example.neostore_app.mycart.MyCartResponse
import com.example.neostore_app.resetpassword.PasswordUpdateResponse
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


@GET("api/products/getList")
fun productList(
    @Query("product_category_id")product_category_id:String,
    @Query("limit")limit:String,
    @Query("page")page:String


):Observable<ProductResponse>
    @GET("api/products/getDetail")

    fun productsDetails(

        @Query("product_id")product_id:String
    ):Observable<ProductDetailResponse>

    @FormUrlEncoded
    @POST("api/products/setRating")

    fun setRating(
        @Field("product_id")product_id:String,
        @Field("rating")rating:String

    ):Observable<RatingResponse>

    @FormUrlEncoded
    @POST("api/addToCart")

    fun setQuantity(

        @Header("access_token")access_token: String,
        @Field("product_id")product_id: String,
        @Field("quantity")quantity:String

    ):Observable<AddCartResponse>



@GET("api/users/getUserData")
fun userData(
    @Header("access_token")access_token:String

):Observable<UserResponse>
  @FormUrlEncoded
 @POST("api/users/update")
 fun editProfile(
     @Header("access_token")access_token: String,
     @Field("first_name")first_name: String,
     @Field("last_name")last_name: String,
     @Field("dob")dob:String,
     @Field("profile_pic")profile_pic:String?,
     @Field("email")email: String,
     @Field("phone_no")phone_no:String

  ):Observable<EditDataResponse>

    @FormUrlEncoded
    @POST("api/users/change")
    fun resetPassword(
        @Header("access_token")access_token: String,
        @Field("old_password")old_password:String,
    @Field("password")password:String,
        @Field("confirm_password")confirm_password:String

    ):Observable<PasswordUpdateResponse>

    @GET("api/cart")
    fun cartDetail(
        @Header("access_token")access_token: String

    ):Observable<MyCartResponse>

    @FormUrlEncoded
    @POST("api/order")

    fun placeOrder(
        @Header("access_token")access_token: String,
        @Field("address")address:String

    ):Observable<OrderResponse>

}