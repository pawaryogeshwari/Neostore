package com.example.neostore_app.ProductDetail

data class Data(
    val cost: Int,
    val created: String,
    val description: String,
    val id: Int,
    val modified: String,
    val name: String,
    val producer: String,
    val product_category_id: Int,
    val product_images: List<ProductImage>,
    val rating: Float,
    val view_count: Int
)