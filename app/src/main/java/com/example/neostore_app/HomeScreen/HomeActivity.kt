package com.example.neostore_app.HomeScreen


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import android.view.Gravity
import android.view.Menu
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.Login.LoginContract
import com.example.neostore_app.Login.LoginPresnter
import com.example.neostore_app.Product.ProductActivity
import com.example.neostore_app.R

import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*


class HomeActivity : BaseActivity(),LoginContract.View
{


    override val getPresenter: BasePresenter = LoginPresnter(this)

    override val getLayout= R.layout.activity_home


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      setToolbar("NeoSTORE")

        iv_menu.setOnClickListener {
            drawer_layout.openDrawer(Gravity.LEFT)
        }
        ivTables.setOnClickListener {
            navigateToProductDetail("1")
        }

        ivSofa.setOnClickListener {
           navigateToProductDetail("3")
        }

        ivChairs.setOnClickListener {
            navigateToProductDetail("2")

        }
        ivCupboards.setOnClickListener {

         navigateToProductDetail("5")
        }
        init()

    }

    private fun navigateToProductDetail(id : String){
        val bundle=Bundle()
        bundle.putString("product_id",id)
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun init()
    {
        val adapter = ViewPagerAdapter(this)
        viewpager.adapter = adapter
        indicator.setViewPager(viewpager)

        val img = adapter.Image

        indicator.fillColor = (Color.RED)
        indicator.pageColor = (Color.BLACK)
        indicator.radius = 12f
        indicator.isCentered = true

        val handler = Handler()
        val Update = Runnable {
            if (currentPage == img.size) {
                currentPage = 0
            }
           viewpager.setCurrentItem(currentPage++, true)
        }
        val swipeTimer = Timer()
        swipeTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, 2500, 2500)

    }

   override fun onCreateOptionsMenu(menu: Menu): Boolean {
       val inflater = menuInflater
       inflater.inflate(R.menu.menu_search, menu)
       return true
   }

    companion object {

        private lateinit var viewPager: ViewPager
        private var currentPage = 0

    }


    override fun loginSucess(message: String) {

    }

    override fun loginFailure(message: String) {
    }

    override fun showEmailError() {
    }

    override fun showPasswordError() {

    }
}



