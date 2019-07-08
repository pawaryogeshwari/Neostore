package com.example.neostore_app.Product

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class ProductActivity : BaseActivity() ,ProductContract.View{
    override val getLayout = R.layout.activity_product

 var presenter = ProductPresenter(this)

    override val getPresenter: BasePresenter
        get() = presenter

    override fun getProduct(message: String) {


    }


    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    var listOfProduct: ArrayList<ProductResponse> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        iv_menu.visibility = View.GONE

        tvtitle.text = getString(R.string.table)

//        for (i in 0..4)
//        {
//            val user = ProductResponse()
//            user.id = i
//            user.login = "Products $i"
//            listOfProduct.add(user)
//        }

        mRecyclerView = findViewById(R.id.my_recycler_view)
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRecyclerView!!.layoutManager = mLayoutManager
        mAdapter = Myadapter(listOfProduct)
        mRecyclerView!!.adapter = mAdapter


    }


}

