package com.example.neostore_app.Product


import com.google.gson.annotations.SerializedName


data class ProductResponse(

	@field:SerializedName("data")
	val data:List<DataItem>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)