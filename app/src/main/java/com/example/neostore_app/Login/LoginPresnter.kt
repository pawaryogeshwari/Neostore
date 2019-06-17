package com.example.neostore_app.Login

import android.text.TextUtils
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import com.example.neostore_app.model.LoginResponse
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

        val apiService = ApiManager.getClient().create(Api::class.java)
        apiService.userLogin(email, password)
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                    mview?.loginFailure("Login Failed")

                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {


                    if (response.body() != null) {

                        mview?.loginSucess(response.body()?.message!!)

                    } else {

                        mview?.loginFailure("login failed")

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