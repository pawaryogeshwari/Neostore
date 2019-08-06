package com.example.neostore_app.orderdetail

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class OrderDetailModel:ViewModel()
{
    val apiclient  = ApiManager.getClient().create(Api::class.java)
    private val detailsOfOrder: MutableLiveData<OrderIdResponse> = MutableLiveData()
    fun orderResponse(): MutableLiveData<OrderIdResponse> = detailsOfOrder

    fun orderId(access_token:String,order_id:String)
    {

        apiclient.orderDetail(access_token, order_id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(

                onNext = {

                    detailsOfOrder.postValue(it)

                },
                onError = {

                    detailsOfOrder.postValue(null)
                },
                onComplete = {


                }

                )


    }


}