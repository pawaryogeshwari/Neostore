package com.example.neostore_app.orderdetail

import com.google.gson.annotations.SerializedName

data class OrderIdResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Int? = null
)