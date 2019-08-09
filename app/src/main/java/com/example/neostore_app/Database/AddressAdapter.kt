package com.example.neostore_app.Database

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.RadioButton
import android.widget.TextView
import com.example.neostore_app.Database.entities.Address
import com.example.neostore_app.R
import kotlinx.android.synthetic.main.add_row.view.*

class AddressAdapter(val access_t:String,private val mContext: Context, private val mData: MutableList<Address>,listener:OnClickAddress):BaseAdapter() {

    lateinit var address:String
     var access_token = access_t
    var list = listener


    fun addAll(address: List<Address>) {
        mData.clear()
        mData.addAll(address)
        notifyDataSetChanged()
    }



    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView
        val viewHolder: ViewHolder

        if (view != null) {
            viewHolder = view.tag as ViewHolder
            address = mData[position].address
        } else {
            view = LayoutInflater.from(mContext)
                .inflate(R.layout.add_row, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
            address = mData[position].address
            viewHolder.title.text = String.format("%s ", address)
        }

           viewHolder!!.title.text = String.format("%s ", address)


       viewHolder.id.setOnClickListener {

            list.setAddress(access_token,mData[position].address)

       }


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



   inner class ViewHolder(view: View) {

        var title: TextView = view.tv_address

        var id:RadioButton = view.rb_address

    }


    interface OnClickAddress{

        fun setAddress(access_token:String,address:String)
    }
}