package com.example.neostore_app.Myaccount

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.neostore_app.EditProfile.EditProfileActivity
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import com.example.neostore_app.resetpassword.ResetPasswordActivity
import kotlinx.android.synthetic.main.activity_myaccount.*
import kotlinx.android.synthetic.main.toolbar.*

class MyAccountActivity() :BaseActivity() {
    override val getLayout = R.layout.activity_myaccount

    lateinit var viewModel: MyAccountViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        iv_menu.visibility = View.GONE
        setToolbar("My Account")
        setToolbarAsBack()

        btn_edit_profile.setOnClickListener {

            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)

        }

        btn_reset_password.setOnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)

        }


        viewModel = ViewModelProviders.of(this).get(MyAccountViewModel::class.java)
        val settings = getSharedPreferences("LoginDetails", 0)
       // val test = settings.getString("email", null)
        val test =settings.getString("access_token", null)
        viewModel.userDetails(test)

        fun myAccountResponse(res: UserResponse) {
            et_first_name.setText(res.data.user_data.first_name)
            et_last_name.setText(res.data.user_data.last_name)
            et_email_add.setText(res.data.user_data.email)
            et_phone_number.setText(res.data.user_data.phone_no)
       et_birth_date.setText(res.data.user_data.dob.toString())

        }

        viewModel.userResponse().observe(this, Observer<UserResponse>{


            if (it!= null)
            {
                myAccountResponse(it)

            }

            else
            {

                showMessage("Details not found")
            }




        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        return true
    }
}