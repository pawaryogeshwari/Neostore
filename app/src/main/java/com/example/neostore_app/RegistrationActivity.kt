package com.example.neostore_app

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : BaseActivity() {

    override var getLayout = R.layout.activity_registration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        btn_register.setOnClickListener{

            val reg=Intent(this@RegistrationActivity,HomeActivity::class.java)
            startActivity(reg)
        }
        }


}


