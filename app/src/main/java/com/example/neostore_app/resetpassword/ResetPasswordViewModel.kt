package com.example.neostore_app.resetpassword

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class ResetPasswordViewModel:ViewModel() {

    val apiclient  = ApiManager.getClient().create(Api::class.java)
    private val resetpwd: MutableLiveData<PasswordUpdateResponse> = MutableLiveData()
    fun passwordDataResponse(): MutableLiveData<PasswordUpdateResponse> = resetpwd

    fun resetPwd(access_token:String,old_password:String,password:String,confirm_password:String)

    {
        apiclient.resetPassword(access_token, old_password, password, confirm_password).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(

                onNext = {
                    if (it!=null)
                    {
                        resetpwd.postValue(it)
                    }
                },
                onError = {

                    resetpwd.postValue(null)
                },
                onComplete = {

                }
            )

    }

}