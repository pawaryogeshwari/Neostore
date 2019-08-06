package com.example.neostore_app.orderdetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_orderdetail.*
import kotlinx.android.synthetic.main.toolbar.*

class OrderDetailActivity:BaseActivity() {
    override val getLayout = R.layout.activity_orderdetail

    private var mAdapter:OrderDetailAdapter? = null


lateinit var viewModel: OrderDetailModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        iv_menu.visibility = View.GONE

        setToolbarAsBack()




        fun setAdapter(res:OrderIdResponse)
        {
            mAdapter = OrderDetailAdapter(this, res.data!!.orderDetails)
            recycler_view.layoutManager = LinearLayoutManager(this)
            recycler_view.adapter = mAdapter
        }

        fun response(res:OrderIdResponse)
        {
        val id  = "Order Id : "+res.data!!.id.toString()
            total_cost.text = "Rs: "+res.data.cost.toString()

            setToolbar(id)
        }





        val settings = getSharedPreferences("LoginDetails", 0)
       val test = settings.getString("access_token", null)

        viewModel = ViewModelProviders.of(this).get(OrderDetailModel::class.java)

        viewModel.orderId(test,intent.extras?.get("order_id").toString())

        viewModel.orderResponse().observe(this, Observer {


            if (it!=null)
            {
                setAdapter(it)
                response(it)


            }
            else
            {
                showMessage("Error")
            }





        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        return true
    }




}