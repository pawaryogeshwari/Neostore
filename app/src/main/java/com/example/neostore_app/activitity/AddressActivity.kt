package com.example.neostore_app.activitity

import android.database.Observable
import android.os.Bundle
import com.example.neostore_app.Database.AppDb
import com.example.neostore_app.Database.entities.Address
import com.example.neostore_app.R
import kotlinx.android.synthetic.main.activity_address.*

class AddressActivity:BaseActivity() {
    override val getLayout = R.layout.activity_address

    lateinit var address: String
    lateinit var city: String
    lateinit var state: String
    lateinit var mdb: AppDb
    lateinit var zipcode: String
    lateinit var country: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        mdb = AppDb.getInstance(this)




            btn_saveAddress.setOnClickListener {

                val thread = Thread {


                    address = et_address.text.toString()
                    city = et_city.text.toString()
                    state = et_state.text.toString()
                    zipcode = et_zopcode.text.toString()
                    country = et_country.text.toString()

                val addAddress = Address(0,address, city, state, zipcode, country)

                mdb.addressDao().addAdreess(addAddress)

            }
                thread.start()
        }


    }
}
