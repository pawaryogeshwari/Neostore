package com.example.neostore_app.orderdetail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.neostore_app.R
import com.squareup.picasso.Picasso

class OrderDetailAdapter(mContext:Context,private var data:List<OrderDetailsItem>?):RecyclerView.Adapter<OrderDetailAdapter.MyViewHolder>() {

    private var context:Context? = null


    init {
        context = mContext

    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): OrderDetailAdapter.MyViewHolder {


        val view = LayoutInflater.from(context).inflate(R.layout.orderdetail_row,p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    override fun onBindViewHolder(p0: OrderDetailAdapter.MyViewHolder, p1: Int) {

        p0.productName.text = data!![p1].prodName
        p0.tv_product_category.text = data!![p1].prodCatName
        p0.tv_Quantity.text  = "QTY: "+data!![p1].quantity.toString()
      p0.tv_cost.text = "Rs:"+data!![p1].total.toString()
        Picasso.get().load(data!![p1].prodImage).into(p0.productImg)

    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        internal var productImg = itemView.findViewById<View>(R.id.ivProduct_Images) as ImageView
        internal val productName  =itemView.findViewById<View>(R.id.tv_products) as TextView
       internal  val  tv_product_category = itemView.findViewById<View>(R.id.tv_product_Category) as TextView
       internal  var tv_Quantity = itemView.findViewById<View>(R.id.tv_Quantity)as TextView
       internal var tv_cost = itemView.findViewById<View>(R.id.tv_Cost) as TextView



    }

}