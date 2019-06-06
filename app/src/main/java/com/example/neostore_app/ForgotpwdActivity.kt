package com.example.neostore_app

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_forgotpwd.*
import kotlinx.android.synthetic.main.activity_login_screen.*

class ForgotpwdActivity :BaseActivity() {

    override var getLayout = R.layout.activity_forgotpwd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)
        //setSupportActionBar(toolbar)

    }
}

