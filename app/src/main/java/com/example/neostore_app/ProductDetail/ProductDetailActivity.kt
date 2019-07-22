package com.example.neostore_app.ProductDetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.TextView
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_prouctdetailrow.*

class ProductDetailActivity :BaseActivity(),ProductAdapter.OnClickListerner {


    private  var data1:List<ProductImage>? = null



    override fun onItemClick(position: Int,image:String) {

    Picasso.get().load(image).into(ivProductImg)

    }



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
                response(it)

            }

            else
            {
                showMessage("Error")
            }

        })
    }

    private fun setAdapter(product:ProductDetailResponse ) {
        myadapter = ProductAdapter(this,product.data.product_images,this)
        recycler_view.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recycler_view.adapter = myadapter
    }




    private fun response(res:ProductDetailResponse)
    {
        val name = res.data.name
        val producer    = res.data.producer
        val cost = res.data.cost
        val desc   = res.data.description
        val rating = res.data.rating
        etProductName.text = name
        tvProducerName.text = producer
        tvCost.text = cost.toString()
        tvDesc.text = desc
        RatingBar.rating = rating.toFloat()


    }

}
