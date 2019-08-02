package com.example.neostore_app.AddressListening

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class AddressViewModel:ViewModel() {


    val apiclient  = ApiManager.getClient().create(Api::class.java)
    private val placeorder: MutableLiveData<OrderResponse> = MutableLiveData()
    fun orderRespone(): MutableLiveData<OrderResponse> = placeorder


    fun order(access_token:String,address:String)
    {
        apiclient.placeOrder(access_token, address).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {

                    if (it!=null)
                    {
                        placeorder.postValue(it)
                    }

                },
                onError = {

                    placeorder.postValue(null)
                },
                onComplete = {


                }

            )



    }
}