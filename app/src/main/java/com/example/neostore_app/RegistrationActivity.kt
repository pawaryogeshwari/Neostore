package com.example.neostore_app

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Toast
import com.example.neostore_app.activitity.BaseActivity
import com.example.neostore_app.model.Api
import com.example.neostore_app.model.ApiManager
import com.example.neostore_app.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login_screen.*
import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationActivity : BaseActivity() {

    override var getLayout = R.layout.activity_registration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        btn_register.setOnClickListener {

            val first_name = textFirstName.text.toString().trim()
            val last_name = textLastName.text.toString().trim()
            val email = textEmail.text.toString().trim()
            val password = textPassword.text.toString().trim()
            val confirm_password = textConfirmPassword.text.toString()
            //val phone_no:Number = textPhoneNumber.text
            val phone_no = Integer.parseInt(textPhoneNumber.text.toString())



            ApiManager.getClient().create(Api::class.java)
                .userCreate(first_name,last_name,email,password,confirm_password,phone_no)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        showMessage("Login failed")
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                        when {
                            response.body()?.status == 400 -> showMessage("please enter user details")
                            response.body()?.status == 500 -> showMessage("internal server error")
                            response.body()?.status == 200 -> {

                            }
                        }
                    }


                })
        }

    }
}


