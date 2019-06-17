package com.example.neostore_app.Login

import com.example.neostore_app.BasePresenter
import com.example.neostore_app.BaseView

interface LoginContract {
    interface View : BaseView
    {
        fun loginSucess(message:String)
        fun loginFailure(message: String)
        fun showEmailError()
        fun showPasswordError()
    }
    interface Presenter: BasePresenter {

        fun login(email:String,password:String)
        fun validateData(email:String,password: String):Boolean
    }
}