package com.example.neostore_app.mycart


import com.google.gson.annotations.SerializedName

data class MyCartResponse(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("status")
	val status: Int? = null
)