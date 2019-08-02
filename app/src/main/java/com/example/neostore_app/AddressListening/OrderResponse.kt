package com.example.neostore_app.AddressListening

import com.google.gson.annotations.SerializedName


data class OrderResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("user_msg")
	val userMsg: String? = null
)