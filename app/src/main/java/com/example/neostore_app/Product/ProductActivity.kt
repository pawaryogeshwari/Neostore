package com.example.neostore_app.Product

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.toolbar.*

class ProductActivity : BaseActivity() ,ProductContract.View{
    override val getLayout = R.layout.activity_product

var presenter = ProductPresenter(this,this)

    override val getPresenter: BasePresenter
        get() = presenter



    override fun getProduct(message: String) {


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        iv_menu.visibility = View.GONE

        setSupportActionBar(id_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

       setToolbar("Tables")
        presenter.productList(intent.extras?.get("product_id").toString(),"10","1")
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        presenter.setAdapter(my_recycler_view)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        return true
    }


}

