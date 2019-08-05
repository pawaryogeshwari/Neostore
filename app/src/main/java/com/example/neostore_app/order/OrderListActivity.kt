package com.example.neostore_app.order

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_orderlist.*
import kotlinx.android.synthetic.main.toolbar.*

class OrderListActivity:BaseActivity() {
    override val getLayout = R.layout.activity_orderlist

    lateinit var viewModel: OrderViewModel
    private var mAdapter:OrderAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        iv_menu.visibility = View.GONE

        setToolbarAsBack()
        setToolbar("My Orders")



        val settings = getSharedPreferences("LoginDetails", 0)
        val test =settings.getString("access_token", null)


        viewModel = ViewModelProviders.of(this).get(OrderViewModel::class.java)

        viewModel.orderList(test)

        viewModel.orderResponse().observe(this, Observer {


            if (it!=null)
            {

                setAdapter(it)
                showMessage(it.message)

            }

            else

            {

                showMessage("Error")
            }


        })

    }



    fun setAdapter(res: OrderDetailResponse)
    {
        mAdapter = OrderAdapter(this,res.data)
        order_recycle_view.layoutManager = LinearLayoutManager(this)
        order_recycle_view.adapter = mAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        return true
    }



}