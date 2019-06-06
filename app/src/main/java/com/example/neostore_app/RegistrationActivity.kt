package com.example.neostore_app

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : BaseActivity() {

override var getLayout=R.layout.activity_registration
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)


    }

}
