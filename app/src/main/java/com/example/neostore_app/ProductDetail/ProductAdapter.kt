package com.example.neostore_app.ProductDetail

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.neostore_app.R
import com.squareup.picasso.Picasso



class ProductAdapter(mContext: Context, private var data: List<ProductImage>?, private var listener: OnClickListerner) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    private var context: Context? = null

    var selectedPosition = -1


    init {
        context = mContext

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.activity_productdetail, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return data!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        if (selectedPosition == position) {

            holder.productImg.setBackgroundResource(R.drawable.imageclickcolor)

        } else {
            holder.productImg.background = null
        }


        holder.productImg.setOnClickListener {

            listener.onItemClick(position, data?.get(position)!!.image)
            selectedPosition = position
            notifyDataSetChanged()



        }

        Picasso.get().load(data!![position].image).into(holder.productImg)


    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var productImg = itemView.findViewById<View>(R.id.ivImg) as ImageView


    }

    interface OnClickListerner {

        fun onItemClick(position: Int, image: String)
    }

}






