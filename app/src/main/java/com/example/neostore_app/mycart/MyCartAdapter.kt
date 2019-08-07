package com.example.neostore_app.mycart

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.example.neostore_app.R
import com.squareup.picasso.Picasso


class MyCartAdapter(mContext : Context, private var data:ArrayList<DataItem>?): RecyclerView.Adapter<MyCartAdapter.MyViewHolder>()
    {
        private var context:Context? = null

    init {
        context = mContext
    }



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.my_cart_row, p0, false)
        return MyViewHolder(view)


    }

    override fun getItemCount(): Int {

        when (data) {
            null -> return 0
            else -> return data!!.size
        }
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.productName.text = data?.get(position)?.product!!.name

    holder.producerCategory.text = data?.get(position)?.product!!.productCategory
        holder.productCost.text = data!![position].product!!.cost.toString()

        Picasso.get().load(data!![position].product?.productImages).into(holder.productImage)

        val bundle= Bundle()
        bundle.putString("product_id", data!![position].productId.toString())

    }
        fun removeAt(position: Int) {

            data!!.removeAt(position)
            notifyItemRemoved(position)
        }


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {

        internal var productImage = itemView.findViewById<View>(R.id.ivProduct_Image) as ImageView
        internal var productName   = itemView.findViewById<View>(R.id.tv_product) as TextView
        internal var producerCategory = itemView.findViewById<View>(R.id.tv_product_category) as TextView
        internal var productCost = itemView.findViewById<View>(R.id.tv_Price)as TextView

    }

    }