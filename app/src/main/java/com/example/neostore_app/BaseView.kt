package com.example.neostore_app

interface BaseView {

    fun showError(message:String)

    fun showLoading()

    fun hideLoading()

    fun logout()
}