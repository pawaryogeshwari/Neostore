package com.example.neostore_app

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import android.widget.Toolbar

class HomeActivity : BaseActivity()
{
override var getLayout=R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)

        setToolBar("Home Screen")

    }



}
