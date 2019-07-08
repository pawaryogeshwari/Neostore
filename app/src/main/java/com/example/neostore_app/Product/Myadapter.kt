package com.example.neostore_app.Product

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.neostore_app.R


class Myadapter(private  val myDataList:ArrayList<ProductResponse>) :  RecyclerView.Adapter<Myadapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter.MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
return myDataList.size
    }

    override fun onBindViewHolder(holder: Myadapter.MyViewHolder, position: Int) {

//        holder.tvProuctname.text = myDataList[position].login
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        internal var tvProuctname: TextView = itemView.findViewById<View>(R.id.tvProductname) as TextView

    }

}