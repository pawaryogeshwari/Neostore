package com.example.neostore_app.mycart

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import com.example.neostore_app.R
import com.example.neostore_app.AddressListening.AddressActivity
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_my_cart.*
import kotlinx.android.synthetic.main.toolbar.*

class MyCartActivity:BaseActivity() {
    override val getLayout = R.layout.activity_my_cart
lateinit var myCartAdapter: MyCartAdapter
    lateinit var viewModel: MyCartViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        iv_menu.visibility = View.GONE

        setToolbarAsBack()
        setToolbar("My Cart")

        val settings = getSharedPreferences("LoginDetails", 0)
        val test =settings.getString("access_token", null)


        viewModel = ViewModelProviders.of(this).get(MyCartViewModel::class.java)


        viewModel.cartList(test)

        viewModel.cartResponse().observe(this, Observer {


            if (it!=null)
            {

                setAdapter(it)
                response(it)

            }

            else
            {
                showMessage("details not found")
            }

        })
        btn_order_now.setOnClickListener {

            val intent = Intent(this, AddressActivity::class.java)
            startActivity(intent)

        }



    }



    private fun setAdapter(res:MyCartResponse)
    {
        myCartAdapter = MyCartAdapter(this,res.data)
        my_recycler_view.layoutManager= LinearLayoutManager(this)
        my_recycler_view.adapter = myCartAdapter

    }

    private fun response(res:MyCartResponse)
    {
       val carttotal = res.total

        total_cost.text = "Rs " + carttotal.toString()





    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        return true
    }


}