package com.example.neostore_app.AddressListening

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.example.neostore_app.Database.AddressAdapter
import com.example.neostore_app.Database.AppDb
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_addresslist.*
import kotlinx.android.synthetic.main.toolbar.*

class AddressListActivity : BaseActivity() ,AddressAdapter.OnClickAddress {

    lateinit var viewModel: AddressViewModel

    lateinit var mdb: AppDb
    lateinit var madapter: AddressAdapter
    private var add: String? = null
    lateinit var test: String

    override fun setAddress(access_token: String, address: String) {

        test = access_token
        add = address
    }

    override val getLayout = R.layout.activity_addresslist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        iv_menu.visibility = View.GONE

        setToolbarAsBack()

        setToolbar("Address List")

        val settings = getSharedPreferences("LoginDetails", 0)
        test = settings.getString("access_token", null)

        viewModel = ViewModelProviders.of(this).get(AddressViewModel::class.java)


        madapter = AddressAdapter(test,this@AddressListActivity, mutableListOf(), this)
        add_recycle_view.adapter = madapter


        val thread = Thread {


            mdb = AppDb.getInstance(this)
            val address = mdb.addressDao().getAddress()

            runOnUiThread {
                madapter.addAll(address)

            }


        }
        thread.start()


        btn_placeOrder.setOnClickListener {

            viewModel.order(test, add!!)

            viewModel.orderRespone().observe(this, Observer {

                if (it != null) {
                 showMessage(it.message)
                } else {
                    showMessage("Error")
                }

            })


        }

    }
}


