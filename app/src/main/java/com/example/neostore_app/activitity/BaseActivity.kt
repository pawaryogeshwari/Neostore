package com.example.neostore_app.activitity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.BaseView
import com.example.neostore_app.ProductDetail.ProductViewModel
import com.example.neostore_app.R
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity:AppCompatActivity(),BaseView {

    abstract val getLayout: Int
    lateinit var getPresenter:BasePresenter

//    abstract var mDisposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)



    }


    fun setToolbar(title:String)
    {

        setSupportActionBar(id_toolbar)
        supportActionBar?.title = null
        tvtitle.text = title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


fun setToolbarAsBack()
{
    setSupportActionBar(id_toolbar)
    supportActionBar?.title = null
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
    supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp)
}



    fun showMessage(message : String?){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()

    }

//    override fun onDestroy() {
//        super.onDestroy()
//        mDisposable.dispose()
//    }
//


    override fun showError(message:String){

    }

    override fun showLoading(){

    }

    override fun hideLoading(){

    }

    override fun logout(){

    }
}
