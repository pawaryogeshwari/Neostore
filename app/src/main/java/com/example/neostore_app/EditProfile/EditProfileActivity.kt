package com.example.neostore_app.EditProfile

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import com.example.neostore_app.Myaccount.MyAccountViewModel
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.toolbar.*

class EditProfileActivity : BaseActivity() {
    override val getLayout = R.layout.activity_edit_profile
lateinit var viewModel:EditProfileViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        iv_menu.visibility = View.GONE


        viewModel = ViewModelProviders.of(this).get(EditProfileViewModel::class.java)

//        val settings = getSharedPreferences("LoginDetails", 0)
        // val test = settings.getString("email", null)


        btn_submit.setOnClickListener {

          val firstName = et_first_name.text.toString()
          val lastName = et_last_name.text.toString()
            val dob = et_birth_date.text.toString()
          val emailadd = et_email_add.text.toString()

            val settings = getSharedPreferences("LoginDetails", 0)
            val test =settings.getString("access_token", null)
            viewModel.editProfileData(test,firstName,lastName,dob,null,emailadd)

        }

        viewModel.editDataResponse().observe(this, Observer
        {

            if (it!=null)
            {


            }
            else
            {
                showMessage("error")

            }


        })





    }
}
