package com.example.neostore_app.MVP

import android.text.TextUtils


class LoginPresnter(view: LoginContract.View) : LoginContract.Presenter
{
var mview : LoginContract.View?=null
init {
    mview = view
}


    override fun onStart() {

    }

    override fun onDistroy() {
    }

    override fun userLogin(email: String, password: String) {


    }

    override fun validateData(email: String, password: String): Boolean {


        when {
            TextUtils.isEmpty(email) -> {

                mview?.showEmailError()
                return false
            }
            TextUtils.isEmpty(password) -> {
                mview?.showPasswordError()
                return false
            }
            else -> return true
        }
    }

}