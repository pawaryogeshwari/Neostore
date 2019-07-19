package com.example.neostore_app.ProductDetail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.neostore_app.R
import com.squareup.picasso.Picasso

class ProductAdapter(mContext : Context, private var data: List<ProductImage>?) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>(){

    private var context:Context? = null

    init {
        context = mContext
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductAdapter.MyViewHolder {


        val view = LayoutInflater.from(context).inflate(R.layout.activity_productdetail,p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return data!!.size
    }

    override fun onBindViewHolder(p0: ProductAdapter.MyViewHolder, p1: Int) {

        Picasso.get().load(data!![p1].image).into(p0.productImg)

    }


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        internal var productImg = itemView.findViewById<View>(R.id.ivImg) as ImageView


    }

    interface OnClickListerner {
        fun OnItemClick(position:Int)


    }

}






