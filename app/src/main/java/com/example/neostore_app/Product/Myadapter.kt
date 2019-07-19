package com.example.neostore_app.Product

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.neostore_app.ProductDetail.ProductDetailActivity
import com.example.neostore_app.R
import com.squareup.picasso.Picasso


class Myadapter(mContext : Context, private var data: List<DataItem>?) : RecyclerView.Adapter<Myadapter.MyViewHolder>() {

    private var context:Context? = null

   init {
       context = mContext
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.row, parent, false)
        return MyViewHolder(view)

    }



    override fun getItemCount(): Int {
return data!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.prouctname.text = data!![position].name
        holder.producer.text = data!![position].producer
        holder.productCost.text = data!![position].cost.toString()
        holder.ratingbar.rating = data!![position].rating!!.toFloat()
        holder.relative.setOnClickListener {
            data!![position].id

            val intent = Intent(context , ProductDetailActivity::class.java)
            intent.putExtra("id", data!![position].id)
            context?.startActivity(intent)




        }

        Picasso.get().load(data!![position].productImages!!).into(holder.product)

    }


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {

        internal var product = itemView.findViewById<View>(R.id.ivProducts) as ImageView
        internal var prouctname   = itemView.findViewById<View>(R.id.tvProductname) as TextView
        internal var producer = itemView.findViewById<View>(R.id.tvProducer) as TextView
        internal var productCost = itemView.findViewById<View>(R.id.tvProductCost)as TextView
        internal var ratingbar= itemView.findViewById(R.id.rating) as RatingBar
        internal var relative = itemView.findViewById(R.id.RelativeLayout) as RelativeLayout

    }

}