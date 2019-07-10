package com.example.neostore_app.Product

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
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


        tvtitle.text = getString(R.string.table)
        presenter.productList(intent.extras?.get("product_id").toString(),"10","1")
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        presenter.setAdapter(my_recycler_view)


    }


}

