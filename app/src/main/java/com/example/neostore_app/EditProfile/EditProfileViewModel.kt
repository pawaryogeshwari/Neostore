package com.example.neostore_app.EditProfile

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class EditProfileViewModel:ViewModel() {



    val apiclient  = ApiManager.getClient().create(Api::class.java)
    private val edituserdata: MutableLiveData<EditDataResponse> = MutableLiveData()
    fun editDataResponse(): MutableLiveData<EditDataResponse> = edituserdata


    fun editProfileData(access_token:String,first_name: String,last_name: String,dob:String,profile_pic:String?,email:String,phone_no:String)
    {

        apiclient.editProfile(access_token,first_name, last_name, dob, profile_pic,email,phone_no).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    edituserdata.postValue(it)
                },
                onError = {

                    edituserdata.postValue(null)
                },
                onComplete = {


                }
            )


    }

}