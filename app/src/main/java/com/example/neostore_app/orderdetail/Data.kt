package com.example.neostore_app.orderdetail

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("cost")
	val cost: Int? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("order_details")
	val orderDetails: List<OrderDetailsItem>? = null
)