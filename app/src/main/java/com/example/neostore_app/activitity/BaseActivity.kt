package com.example.neostore_app.activitity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.BaseView

abstract class BaseActivity:AppCompatActivity(),BaseView {

    abstract val getLayout: Int
   abstract val getPresenter:BasePresenter

//    abstract var mDisposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout)



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
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
