package com.example.neostore_app.activitity

import android.os.Bundle
import android.view.View
import com.example.neostore_app.Database.AppDb
import com.example.neostore_app.R
import kotlinx.android.synthetic.main.activity_addresslist.*
import kotlinx.android.synthetic.main.toolbar.*

class AddressListActivity :BaseActivity() {
    override val getLayout = R.layout.activity_addresslist
    lateinit var mdb: AppDb

    lateinit var madapter: AddressAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        iv_menu.visibility = View.GONE

        setToolbarAsBack()

        setToolbar("Address List")

        madapter = AddressAdapter(this@AddressListActivity, mutableListOf())
        add_recycle_view.adapter = madapter



        val thread = Thread {



            mdb = AppDb.getInstance(this)

          val address=  mdb.addressDao().getAddress()
            madapter.addAll(address)

        }
            thread.start()
    }
}
