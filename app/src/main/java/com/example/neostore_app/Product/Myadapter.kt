package com.example.neostore_app.Product

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.example.neostore_app.R
import com.squareup.picasso.Picasso


class Myadapter : RecyclerView.Adapter<Myadapter.MyViewHolder> {

    private var data: List<DataItem>? = null
    private var context: Context? = null

constructor(data: List<DataItem>?, context: Context?)
{
    this.data = data
    this.context = context
}



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter.MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
return data!!.size
    }

    override fun onBindViewHolder(holder: Myadapter.MyViewHolder, position: Int) {

        holder.prouctname.text = data!!.get(position).name
        holder.producer.text = data!!.get(position).producer
        holder.productCost.text = data!!.get(position).cost.toString()
        holder.ratingbar.rating = data!!.get(position).rating!!.toFloat()


        Picasso.get().load(data!!.get(position).productImages!!).into(holder.product)

    }


    fun setToAdapter(data: List<DataItem>?) {

        this.data = data
        notifyDataSetChanged()

    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {

        internal var product = itemView.findViewById<View>(R.id.ivProducts) as ImageView
        internal var prouctname   = itemView.findViewById<View>(R.id.tvProductname) as TextView
        internal var producer = itemView.findViewById<View>(R.id.tvProducer) as TextView
        internal var productCost = itemView.findViewById<View>(R.id.tvProductCost)as TextView
        internal var ratingbar= itemView.findViewById(R.id.rating) as RatingBar

    }

}