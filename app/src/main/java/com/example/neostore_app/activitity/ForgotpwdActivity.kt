package com.example.neostore_app.activitity

import android.os.Bundle
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.Login.LoginContract
import com.example.neostore_app.Login.LoginPresnter
import com.example.neostore_app.R

class ForgotpwdActivity : BaseActivity(),LoginContract.View {


    var  presnter = LoginPresnter(this)
    override val getPresenter: BasePresenter
        get() = presnter

    override var getLayout = R.layout.activity_forgotpwd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)
        //setSupportActionBar(toolbar)

    }

    override fun loginSucess(message: String) {

    }

    override fun loginFailure(message: String) {
    }

    override fun showEmailError() {
    }

    override fun showPasswordError() {
    }
}

