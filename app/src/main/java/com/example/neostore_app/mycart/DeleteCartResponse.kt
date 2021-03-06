package com.example.neostore_app.mycart

import com.google.gson.annotations.SerializedName

data class DeleteCartResponse(

	@field:SerializedName("total_carts")
	val totalCarts: Int? = null,

	@field:SerializedName("data")
	val data: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("user_msg")
	val userMsg: String? = null
)