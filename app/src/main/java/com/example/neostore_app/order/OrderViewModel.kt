package com.example.neostore_app.order

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.neostore_app.AddressListening.OrderResponse
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class OrderViewModel:ViewModel() {

    val apiclient  = ApiManager.getClient().create(Api::class.java)
    private val orderlist: MutableLiveData<OrderDetailResponse> = MutableLiveData()
    fun orderResponse(): MutableLiveData<OrderDetailResponse> = orderlist


    fun orderList(access_token:String)
    {

        apiclient.displayListOfOrder(access_token).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(

                onNext = {

                    orderlist.postValue(it)
                },onError = {

                    orderlist.postValue(null)
                },

                onComplete = {


                })




    }

}