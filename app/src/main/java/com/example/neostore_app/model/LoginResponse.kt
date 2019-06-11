package com.example.neostore_app.model

data class LoginResponse (
    val message:String,
    val status:Int
)
data class User(val email:String,
                val username:String
)

