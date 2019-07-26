package com.example.neostore_app.Login

import android.text.TextUtils
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


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

val apiservice = ApiManager.getClient().create(Api::class.java)

          apiservice.userLogin(email, password).subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
              .subscribeBy(
               onNext = {
                    if(it!=null)
                   {
                     mview?.loginSucess(it)
                }
               },
                  onError = {
                    mview?.loginFailure("Login Failed")
                   },
                  onComplete = {
                    mview?.loginSucessMessage("Login Sucessful")

                  }
              )



    }



    override fun validateData(email: String, password: String): Boolean {


        return when {
            TextUtils.isEmpty(email) -> {

                mview?.showEmailError()
                false
            }
            TextUtils.isEmpty(password) -> {
                mview?.showPasswordError()
                false
            }
            else -> true
        }
    }
}

