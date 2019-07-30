package com.example.neostore_app.mycart

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("product")
	val product: Product? = null,

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("product_id")
	val productId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null
)