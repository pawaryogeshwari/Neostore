package com.example.neostore_app.MVP

interface LoginContract {
    interface View
    {
        fun loginSucess()
        fun loginFailure()
        fun showEmailError()
        fun showPasswordError()
    }
    interface Presenter:BasePresenter{

        fun userLogin(email:String,password:String)
        fun validateData(email:String,password: String):Boolean
    }
}