package com.example.neostore_app.order

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.neostore_app.R

class OrderAdapter(mcontext:Context,private var data:List<DataItem>?): RecyclerView.Adapter<OrderAdapter.MyViewHolder>() {

    private var context:Context? = null

    init {
        context = mcontext
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): OrderAdapter.MyViewHolder
    {


        val view = LayoutInflater.from(context).inflate(R.layout.orderlist_row, p0, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {

        return data!!.size
    }

    override fun onBindViewHolder(p0: OrderAdapter.MyViewHolder, p1: Int) {

        p0.id.text = "Order Id: "+data!![p1].id.toString()
        p0.cost.text = "Rs: "+data!![p1].cost.toString()
        p0.date.text = "Ordered Date: "+data!![p1].created


    }


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        internal var id = itemView.findViewById<View>(R.id.tv_orderId) as TextView
        internal var cost = itemView.findViewById<View>(R.id.tv_orderCost)as TextView
        internal var date = itemView.findViewById<View>(R.id.tv_orderDate)as TextView
    }




}