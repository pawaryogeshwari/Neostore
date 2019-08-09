package com.example.neostore_app.mycart

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.graphics.*
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.View
import com.example.neostore_app.Database.AddressActivity
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_my_cart.*
import kotlinx.android.synthetic.main.toolbar.*


class MyCartActivity:BaseActivity() {
    override val getLayout = R.layout.activity_my_cart
lateinit var myCartAdapter: MyCartAdapter
    lateinit var viewModel: MyCartViewModel
  var product_id:String = " "


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        iv_menu.visibility = View.GONE

        setToolbarAsBack()
        setToolbar("My Cart")






        val settings = getSharedPreferences("LoginDetails", 0)
        val test =settings.getString("access_token", null)


        viewModel = ViewModelProviders.of(this).get(MyCartViewModel::class.java)


        viewModel.cartList(test)

        viewModel.cartResponse().observe(this, Observer {


            if (it!=null)
            {

                setAdapter(it)
                response(it)

            }

            else
            {
                showMessage("Cart is empty")
            }

        })
        btn_order_now.setOnClickListener {

            val intent = Intent(this, AddressActivity::class.java)
            startActivity(intent)

        }

        val itemTouchHelperCallback = object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT)
        {

            override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
            return false

            }


            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean)

            {
               val icon:Bitmap
                val p = Paint()
                if (actionState== ItemTouchHelper.ACTION_STATE_SWIPE)
                {
                    val itemView = viewHolder.itemView
                    val height = itemView.bottom.toFloat() - itemView.top.toFloat()
                    val width = height / 3



                    if (dX < 0) {
                        p.setColor(Color.parseColor("#D32F2F"))
                        val background = RectF(
                            itemView.right.toFloat() + dX / 4,
                            itemView.top.toFloat(),
                            itemView.right.toFloat(),
                            itemView.bottom.toFloat()
                        )
                        c.drawRect(background, p)
                        icon = BitmapFactory.decodeResource(resources,R.drawable.delete)
                        val icon_dest = RectF(
                            itemView.right.toFloat() - 2 * width,
                            itemView.top.toFloat() + width,
                            itemView.right.toFloat() - width,
                            itemView.bottom.toFloat() - width
                        )
                        c.drawBitmap(icon, null, icon_dest,p)

                    }

                }








                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }



            override fun onSwiped(holder: RecyclerView.ViewHolder, position: Int) {



                viewModel.deleteItem(test,(my_recycler_view.adapter as MyCartAdapter).data!![holder.adapterPosition].productId.toString())
                viewModel.deleteCartResponse().observe(this@MyCartActivity, Observer {

                 if (it!=null)
                 {

                     showMessage(it.message)
                 }
                    else

                 {
                     showMessage("Error")
                 }

                })

                (my_recycler_view.adapter as MyCartAdapter).removeAt(holder)
            }

        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(my_recycler_view)



    }



    private fun setAdapter(res:MyCartResponse)
    {
        myCartAdapter = MyCartAdapter(this,res.data)
        my_recycler_view.layoutManager= LinearLayoutManager(this)
        my_recycler_view.adapter = myCartAdapter

    }

    private fun response(res:MyCartResponse)
    {
       val carttotal = res.total

        total_cost.text = "Rs " + carttotal.toString()





    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        return true
    }


}