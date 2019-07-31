package com.example.neostore_app.EditProfile

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.neostore_app.HomeScreen.HomeActivity
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.toolbar.*

class EditProfileActivity : BaseActivity() {
    override val getLayout = R.layout.activity_edit_profile
lateinit var viewModel:EditProfileViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        iv_menu.visibility = View.GONE

setToolbar("Edit Profile")
        setToolbarAsBack()
        viewModel = ViewModelProviders.of(this).get(EditProfileViewModel::class.java)

//        val settings = getSharedPreferences("LoginDetails", 0)
        // val test = settings.getString("email", null)





        btn_submit.setOnClickListener {

          val firstName = et_first_name.text.toString()
          val lastName = et_last_name.text.toString()
            val dob = et_birth_date.text.toString()
          val emailadd = et_email_add.text.toString()
            val phoneNo = et_phone_number.text.toString()



            val settings = getSharedPreferences("LoginDetails", 0)
            val test =settings.getString("access_token", null)
            viewModel.editProfileData(test,firstName,lastName,dob,"null",emailadd,phoneNo)

        }

        viewModel.editDataResponse().observe(this, Observer
        {

            if (it!=null)
            {

                showMessage("Data updated Successfully")

                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)

            }
            else
            {
                showMessage("error")

            }


        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)
        return true
    }

}
