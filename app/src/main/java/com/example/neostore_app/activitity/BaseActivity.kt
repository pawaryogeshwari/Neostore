package com.example.neostore_app.activitity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.BaseView
import kotlinx.android.synthetic.main.activity_home.*

abstract class BaseActivity:AppCompatActivity(),BaseView {

    abstract val getLayout: Int
    abstract val getPresenter:BasePresenter

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

    override fun onStart() {
        super.onStart()
        getPresenter.start()
    }

    override fun onStop() {
        super.onStop()
        getPresenter.stop()
    }

    override fun showError(message:String){

    }

    override fun showLoading(){

    }

    override fun hideLoading(){

    }

    override fun logout(){

    }
}
