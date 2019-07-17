package com.example.neostore_app.activitity

import android.os.Bundle
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.Login.LoginContract
import com.example.neostore_app.Login.LoginPresnter
import com.example.neostore_app.R
import io.reactivex.disposables.Disposable

class ForgotpwdActivity : BaseActivity() {

//    override var mDisposable: Disposable
//        get() = mDisposable
//        set(value) {}





    override var getLayout = R.layout.activity_forgotpwd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)
        //setSupportActionBar(toolbar)

    }




}

