package com.example.neostore_app.Registration

import android.text.TextUtils
import com.example.neostore_app.model.LoginResponse
import com.example.neostore_app.network.APICallback
import com.example.neostore_app.network.APIRetrofit
import okhttp3.ResponseBody

class RegisterPresenter(view: RegisterContract.view) :RegisterContract.presenter {
    override fun start() {

    }

    override fun stop() {
        mView = null
    }

    var mView: RegisterContract.view? = null

    init {
        mView = view
    }

    override fun register(
        first_name: String,
        last_name: String,
        email: String,
        password: String,
        confirm_password: String,
        phone_no: Long,
        gender: String
    ) {

        APIRetrofit().userCreate(first_name, last_name, email, password, confirm_password, phone_no,
            gender, object : APICallback<LoginResponse>() {
                override fun onFailure(t: Throwable) {
                    mView?.registrationFailure("Registration Failed")
                }



                override fun response(status: Int, response: LoginResponse?) {

                    when (status) {
                        200 -> {
                            mView?.registrationSucess(response?.message!!)
                        }
                        401 -> {
                            mView?.registrationFailure("The provided value is invalid")
                        }

                        else->
                        {mView?.registrationFailure(response?.message!!)}
                    }
                }


            })




    }

    override fun validation(
        first_name: String, last_name: String, email: String,
        password: String, confirm_password: String,
        phone_no: String, gender: String
    ): Boolean {



        when {

            TextUtils.isEmpty(first_name) -> {
                mView?.showFnameError()
                return false
            }
            TextUtils.isEmpty(last_name) -> {
                mView?.showLnameError()
            }

            TextUtils.isEmpty(email) -> {

                mView?.showEmailError()
                return false
            }
            TextUtils.isEmpty(password) -> {
                mView?.showPasswordError()
                return false
            }

            TextUtils.isEmpty(confirm_password)->
            {
                mView?.showConfirmPwdError()
                return false
            }
            TextUtils.isEmpty(phone_no)->
            {
                mView?.showPhonenoError()
                return false
            }


        }
            return true
    }
}