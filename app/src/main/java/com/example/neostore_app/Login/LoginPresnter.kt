package com.example.neostore_app.Login

import android.text.TextUtils
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit


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
                     mview?.loginSucess(it.data?.firstName!!)
                }
               },
                  onError = {
                    mview?.loginFailure("Login Failed")
                   },
                  onComplete = {
                      mview?.loginSucess("Login sucessful")
                  }
              )



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

