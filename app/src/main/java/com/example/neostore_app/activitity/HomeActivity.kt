package com.example.neostore_app.activitity

import android.os.Bundle
import android.view.Menu
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.Login.LoginContract
import com.example.neostore_app.Login.LoginPresnter
import com.example.neostore_app.R

class HomeActivity : BaseActivity(),LoginContract.View
{


    var  presenter = LoginPresnter(this)
    override val getPresenter: BasePresenter
        get() = presenter
    override var getLayout= R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolBar("NeoSTORE")


    }



    override fun loginSucess(message: String) {

    }

    override fun loginFailure(message: String) {
    }

    override fun showEmailError() {
    }

    override fun showPasswordError() {
    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_search, menu)
            return super.onCreateOptionsMenu(menu)
        }


    }



