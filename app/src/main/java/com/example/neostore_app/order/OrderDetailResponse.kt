package com.example.neostore_app.order

import com.google.gson.annotations.SerializedName

data class OrderDetailResponse(

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("user_msg")
	val userMsg: String? = null
)