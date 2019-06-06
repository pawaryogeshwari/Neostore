package com.example.neostore_app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity()
{

    abstract val getLayout:Int
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)

    }
}