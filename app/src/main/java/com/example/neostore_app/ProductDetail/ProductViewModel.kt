package com.example.neostore_app.ProductDetail

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import com.example.neostore_app.Rating.RatingResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

open class ProductViewModel:ViewModel() {


val apiclient  = ApiManager.getClient().create(Api::class.java)
    private val detailsOfProduct: MutableLiveData<ProductDetailResponse> = MutableLiveData()
    fun productResponse(): MutableLiveData<ProductDetailResponse> = detailsOfProduct

    fun product(product_id:String)
    {
        apiclient.productsDetails(product_id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(

                onNext = {

                    if(it!=null)
                    {
                   detailsOfProduct.postValue(it)

                    }

                },

                onError = {

                    detailsOfProduct.postValue(null)
                },

                onComplete = {

                })
    }

    private val productRating: MutableLiveData<RatingResponse> = MutableLiveData()
    fun ratingResponse(): MutableLiveData<RatingResponse> = productRating


    fun setRatingValue(product_id: String,rating:String)
    {
        apiclient.setRating(product_id, rating).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {

                    if(it!=null)
                    {
                        productRating.postValue(it)
                    }
                },
                onError = {
                    Log.d("Tag",it.message)
                    productRating.postValue(null)
                },
                onComplete = {

                }

                )




    }






}