package com.example.neostore_app.activitity

import android.os.Bundle
import android.support.v4.view.ViewPager


import android.view.Menu

import com.example.neostore_app.BasePresenter
import com.example.neostore_app.Login.LoginContract
import com.example.neostore_app.Login.LoginPresnter
import com.example.neostore_app.R

import com.example.neostore_app.ViewPagerAdapter
import me.relex.circleindicator.CircleIndicator
import java.util.*
import java.util.logging.Handler


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
   lateinit var circleindicator : CircleIndicator

    private lateinit var mHandler: Handler
    private lateinit var mRunnable:Runnable
    private lateinit var timer:Timer
    var currentPage  =  0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolBar("NeoSTORE")



        viewpager = findViewById(R.id.viewpager) as ViewPager



            val adapter = ViewPagerAdapter(this)
   viewpager.setAdapter(adapter)

    mRunnable = Runnable {
    fun imageslider() {

        circleindicator = findViewById(R.id.circleindicator) as CircleIndicator

        circleindicator.setViewPager(viewpager)

        fun run() {
            if (currentPage == 4) {
                currentPage = 0
            }
            viewpager.setCurrentItem(currentPage++, true)
        }


    }

    }

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



