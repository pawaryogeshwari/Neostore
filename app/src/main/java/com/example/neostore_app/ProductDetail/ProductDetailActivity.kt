package com.example.neostore_app.ProductDetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_prouctdetailrow.*

class ProductDetailActivity :BaseActivity() {

    override val getLayout = R.layout.activity_prouctdetailrow

    lateinit  var viewModel:ProductViewModel
    private var myadapter: ProductAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)

        viewModel.product(intent.extras.get("id").toString())

        viewModel.productResponse().observe(this, Observer<ProductDetailResponse> {


            if(it!=null)
            {
                setAdapter(it)

            }

            else
            {
                showMessage("Error")
            }

        })






    }

    fun setAdapter(product:ProductDetailResponse ) {
        myadapter = ProductAdapter(this,product.data.product_images)
        recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recycler_view.adapter = myadapter
    }
}
