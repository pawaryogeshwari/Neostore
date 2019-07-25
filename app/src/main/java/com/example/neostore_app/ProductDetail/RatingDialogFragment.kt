package com.example.neostore_app.ProductDetail


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neostore_app.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.ratenowdialogfragment.*



@SuppressLint("ValidFragment")
class RatingDialogFragment(list:OnClickRating,id:String):DialogFragment(){

    lateinit var p:String
    private lateinit var pimage:String
   lateinit var rating:String
 var listener:OnClickRating = list
    var product_id:String = id


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val myView = inflater.inflate(R.layout.ratenowdialogfragment,container,false)


        p = arguments?.getString("product_name")!!
        pimage = arguments?.getString("product_image")!!

        Log.d("TAG","display image")

        return myView

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvProduct_name.text = p

        Picasso.get().load(pimage).into(ivProduct_image)


        btn_RateNow.setOnClickListener {
         rating = rating_bar.rating.toString()
                listener.setRatingValue(product_id,rating)

            dialog.dismiss()
        }
    }


    interface OnClickRating{

        fun setRatingValue(product_id:String,rating:String)
    }
}