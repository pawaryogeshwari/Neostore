package com.example.neostore_app.ProductDetail


import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neostore_app.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialogfragment.*
import kotlinx.android.synthetic.main.row.*

class ProductDialogFrament: DialogFragment() {

lateinit var p:String
    lateinit var pimage:String

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

    }






}