package com.example.neostore_app.ProductDetail

data class ProductImage(
    val created: String,
    val id: Int,
    val image: String,
    val modified: String,
    val product_id: Int,
    var isSelected:Boolean
)