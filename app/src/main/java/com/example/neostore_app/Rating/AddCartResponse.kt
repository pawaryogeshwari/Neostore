package com.example.neostore_app.Rating

data class AddCartResponse(
    val `data`: Boolean,
    val message: String,
    val status: Int,
    val total_carts: Int,
    val user_msg: String
)