package com.example.neostore_app.Login

import android.text.TextUtils
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import com.example.neostore_app.model.LoginResponse
import com.example.neostore_app.network.APICallback
import com.example.neostore_app.network.APIRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginPresnter(view: LoginContract.View) : LoginContract.Presenter {
    var mview: LoginContract.View? = null

    var isRooted = true

    init {
        mview = view
    }


    override fun start() {
        if(isRooted){
            mview?.showError("This is warning for user")
        }

    }

    override fun stop() {

        mview = null
    }


    override fun login(email: String, password: String) {
        APIRetrofit().userLogin(email, password, object : APICallback<LoginResponse>() {
            override fun onFailure(t: Throwable) {

                mview?.loginFailure("login failed")
            }


            override fun response(status: Int, response: LoginResponse?) {

                when(status)
                {
                    200->{mview?.loginSucess(response?.message!!)}
                    401->{mview?.loginFailure("Login Failed")}
                }

            }
        })

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