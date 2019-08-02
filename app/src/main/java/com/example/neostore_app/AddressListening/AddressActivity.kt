package com.example.neostore_app.AddressListening

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.neostore_app.Database.AppDb
import com.example.neostore_app.Database.entities.Address
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_address.*
import kotlinx.android.synthetic.main.activity_addresslist.*
import kotlinx.android.synthetic.main.toolbar.*

class AddressActivity: BaseActivity() {
    override val getLayout = R.layout.activity_address



    lateinit var address: String
    lateinit var city: String
    lateinit var state: String
    lateinit var mdb: AppDb
    lateinit var zipcode: String
    lateinit var country: String
  private var viewModel:AddressViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mdb = AppDb.getInstance(this)

        iv_menu.visibility = View.GONE

        setToolbar("Add Address")

        setToolbarAsBack()
        val settings = getSharedPreferences("LoginDetails", 0)
        val test = settings.getString("access_token", null)

        btn_saveAddress.setOnClickListener {

            val thread = Thread {


                address = et_address.text.toString()
                city = et_city.text.toString()
                state = et_state.text.toString()
                zipcode = et_zipcode.text.toString()
                country = et_country.text.toString()

                val addAddress = Address(0, address, city, state, zipcode, country)

                mdb.addressDao().addAdreess(addAddress)

            }
            thread.start()

            val intent = Intent(this, AddressListActivity::class.java)
            startActivity(intent)
        }






    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        return true
    }

}
