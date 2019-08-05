package com.example.neostore_app.order

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("cost")
	val cost: Int? = null,

	@field:SerializedName("created")
	val created: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)