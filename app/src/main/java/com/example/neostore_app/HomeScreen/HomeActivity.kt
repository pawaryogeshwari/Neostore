package com.example.neostore_app.HomeScreen

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.Gravity


import android.view.Menu

import com.example.neostore_app.BasePresenter
import com.example.neostore_app.Login.LoginContract
import com.example.neostore_app.Login.LoginPresnter
import com.example.neostore_app.R

import com.example.neostore_app.ViewPagerAdapter
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*


class HomeActivity : BaseActivity(),LoginContract.View
{
//    override var mDisposable: Disposable
//        get() = mDisposable
//        set(value) {}


    var  presenter = LoginPresnter(this)
    override val getPresenter: BasePresenter
        get() = presenter
    override var getLayout= R.layout.activity_home

    lateinit var viewpager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tvtitle.setText("NeoSTORE")

       iv_menu.setOnClickListener {
    drawer_layout.openDrawer(Gravity.LEFT)
}



        viewpager = findViewById(R.id.viewpager) as ViewPager


        val adapter = ViewPagerAdapter(this)
        viewpager.setAdapter(adapter)


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



