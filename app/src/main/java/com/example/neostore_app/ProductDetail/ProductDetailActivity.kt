package com.example.neostore_app.ProductDetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.neostore_app.R
import com.example.neostore_app.Rating.AddCartResponse
import com.example.neostore_app.Rating.RatingResponse
import com.example.neostore_app.activitity.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_prouctdetailrow.*
import kotlinx.android.synthetic.main.ratenowdialogfragment.*
import kotlinx.android.synthetic.main.toolbar.*

class ProductDetailActivity :BaseActivity(),ProductAdapter.OnClickListerner,RatingDialogFragment.OnClickRating ,ProductDialogFrament.OnClicKQuantity{
    override fun addToCart(access_token: String, product_id: String, quantity: String) {
        viewModel.setQuantity(access_token, product_id, quantity)

    }




    override val getLayout = R.layout.activity_prouctdetailrow

    lateinit  var viewModel:ProductViewModel
    private var myadapter: ProductAdapter? = null
lateinit var product_id: String
    lateinit var name:String
    lateinit var rating:String
    lateinit var quantity: String
    var imgname:String = ""
    lateinit var img: List<ProductImage>
    var pos:Int = 0


    override fun onItemClick(position: Int,image:String) {

        Picasso.get().load(image).into(ivProductImg)
        pos = position

        imgname = img[0].image
    }


    override fun setRatingValue(product_id: String, rating: String) {

        viewModel.setRatingValue(product_id, rating)
    }


   private fun getRatingData(res: RatingResponse) {
       rating = res.data!!.rating.toString()

       RatingBar.rating = rating.toFloat()
   }

    private fun getQuantity(res:AddCartResponse)
    {
        showMessage(res.message)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        product_id = intent.extras.getInt("id").toString()
        val settings = getSharedPreferences("LoginDetails", 0)
        val test =settings.getString("access_token", null)

        btn_buyNow.setOnClickListener {

            val fm = supportFragmentManager
            val dialog = ProductDialogFrament(this,product_id,test)
            val bundle = Bundle()
            bundle.putString("product_name",name)
            bundle.putString("product_image",imgname)

            dialog.arguments = bundle
            dialog.show(supportFragmentManager,"Product_detail")


        }

        btn_rate.setOnClickListener {

          val dialog = RatingDialogFragment(this,product_id)
           val bundle = Bundle()
            bundle.putString("product_name",name)
           bundle.putString("product_image",imgname)
//         bundle.putString("rating",rate)
            dialog.arguments = bundle
            dialog.show(supportFragmentManager,"Product_detail")

        }







        iv_menu.visibility = View.GONE
        setToolbarAsBack()

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
        viewModel.ratingResponse().observe(this,Observer<RatingResponse>
        {

            if(it!=null)
            {
                getRatingData(it)

            }

            else
            {
                showMessage("Error")
            }

        })


        viewModel.quantityResponse().observe(this, Observer {

            if (it!=null)
            {
                getQuantity(it)

            }

            else
            {
                showMessage("error")
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
        name = res.data.name
        img = res.data.product_images
        rating = res.data.rating.toString()
        Log.d("TAG","position of image")
        val producer = res.data.producer
        val cost = res.data.cost
        val desc   = res.data.description
        etProductName.text = name
        setToolbar(name)
        tvProducerName.text = producer
        tvCost.text = cost.toString()
        tvDesc.text = desc
        RatingBar.rating = rating.toFloat()


    }




}
