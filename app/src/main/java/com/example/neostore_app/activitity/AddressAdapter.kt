package com.example.neostore_app.activitity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.neostore_app.Database.entities.Address
import com.example.neostore_app.R
import kotlinx.android.synthetic.main.add_row.view.*

class AddressAdapter(private val mContext: Context, private val mData: MutableList<Address>):BaseAdapter() {

    fun addAll(address: List<Address>) {
        mData.clear()
        mData.addAll(address)
        notifyDataSetChanged()
    }



    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView
        val viewHolder:ViewHolder

        if (view != null) {
            viewHolder = view.tag as ViewHolder
        } else {
            view = LayoutInflater.from(mContext)
                .inflate(R.layout.add_row, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }
        val address = mData[position]
        viewHolder.title.text = String.format("%s %s %s %s %s", address.address,address.city,address.country,address.state,address.zipcode)
return view!!
    }

    override fun getItem(position: Int): Any {

        return mData[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getCount(): Int {

       return mData.size
    }



    internal class ViewHolder(view: View) {

        var title: TextView = view.tv_address

    }

}