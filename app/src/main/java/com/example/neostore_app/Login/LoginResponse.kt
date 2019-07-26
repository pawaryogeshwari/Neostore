package com.example.neostore_app.Login

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("data")
	val data: UserDataX? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("user_msg")
	val userMsg: String? = null
)

data class UserDataX(
	val access_token: String,
	val country_id: Any,
	val created: String,
	val dob: Any,
	val email: String,
	val first_name: String,
	val gender: String,
	val id: Int,
	val is_active: Boolean,
	val last_name: String,
	val modified: String,
	val phone_no: String,
	val profile_pic: Any,
	val role_id: Int,
	val username: String
)

