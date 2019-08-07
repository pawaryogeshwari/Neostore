package com.example.neostore_app.mycart

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MyCartViewModel:ViewModel() {

    val apiclient  = ApiManager.getClient().create(Api::class.java)
    private val detailOfCart: MutableLiveData<MyCartResponse> = MutableLiveData()
    fun cartResponse(): MutableLiveData<MyCartResponse> = detailOfCart

    fun cartList(access_token:String)
    {
        apiclient.cartDetail(access_token).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {

                    if (it!=null)
                    {
                        detailOfCart.postValue(it)
                    }
                },
                onError = {

                    detailOfCart.postValue(null)
                },
                onComplete = {
                }

                ) }





}