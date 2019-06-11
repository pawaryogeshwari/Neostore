package com.example.neostore_app

import android.os.Bundle
import com.example.neostore_app.activitity.BaseActivity

class ForgotpwdActivity : BaseActivity() {

    override var getLayout = R.layout.activity_forgotpwd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)
        //setSupportActionBar(toolbar)

    }
}

