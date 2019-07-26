package com.example.neostore_app.Myaccount

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MyAccountViewModel :ViewModel(){

    val apiclient  = ApiManager.getClient().create(Api::class.java)
    private val userdetails: MutableLiveData<UserResponse> = MutableLiveData()
    fun userResponse(): MutableLiveData<UserResponse> = userdetails

fun userDetails(access_token:String)
{
    apiclient.userData(access_token).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeBy(
            onNext = {
                userdetails.postValue(it)
            },
            onError = {

                userdetails.postValue(null)
            },
            onComplete = {

            }
        )


}

}

