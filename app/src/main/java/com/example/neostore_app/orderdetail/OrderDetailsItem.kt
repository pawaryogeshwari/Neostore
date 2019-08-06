package com.example.neostore_app.orderdetail

import com.google.gson.annotations.SerializedName

data class OrderDetailsItem(

	@field:SerializedName("prod_image")
	val prodImage: String? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("prod_cat_name")
	val prodCatName: String? = null,

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("product_id")
	val productId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("order_id")
	val orderId: Int? = null,

	@field:SerializedName("prod_name")
	val prodName: String? = null
)