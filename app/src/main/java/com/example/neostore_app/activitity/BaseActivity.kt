package com.example.neostore_app.activitity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_home.*

abstract class BaseActivity:AppCompatActivity() {

    abstract val getLayout: Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)

    }
    fun setToolBar(title: String)
    {

        setSupportActionBar(id_toolbar)
        setTitle(title)

    }

    fun showMessage(message : String?){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
