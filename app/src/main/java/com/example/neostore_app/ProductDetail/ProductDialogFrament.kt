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
import kotlinx.android.synthetic.main.dialogfragment.*

@SuppressLint("ValidFragment")
class ProductDialogFrament(list:OnClicKQuantity, id:String,access_toke:String): DialogFragment() {

lateinit var p:String
    lateinit var pimage:String
    var listener:OnClicKQuantity = list
    var product_id:String = id
    lateinit var quantity: String
    var access_token:String = access_toke

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val myView = inflater.inflate(R.layout.dialogfragment,container,false)


        p = arguments?.getString("product_name")!!
        pimage = arguments?.getString("product_image")!!

        Log.d("TAG","display image")

        return myView

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvProduct_names.text = p
       Picasso.get().load(pimage).into(ivProduct_img)


        btn_submit.setOnClickListener {

           quantity =  et_quantity.text.toString()
            listener.addToCart(product_id, quantity,access_token)

            dialog.dismiss()

        }

    }


    interface OnClicKQuantity
    {
        fun addToCart(access_token: String,product_id:String,quantity:String)

    }




}