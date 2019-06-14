package com.example.neostore_app.activitity

import android.os.Bundle
import android.text.TextUtils
import com.example.neostore_app.R
import com.example.neostore_app.model.Api
import com.example.neostore_app.model.ApiManager
import com.example.neostore_app.model.LoginResponse
import kotlinx.android.synthetic.main.activity_registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationActivity : BaseActivity() {

    var gender:String=""

    override var getLayout = R.layout.activity_registration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        btn_register.setOnClickListener {

            val first_name = textFirstName.text.toString().trim()
            val last_name = textLastName.text.toString().trim()
            val email = textEmail.text.toString().trim()
            val password = textPassword.text.toString().trim()
            val confirm_password = textConfirmPassword.text.toString()

            if(btn_male.isChecked)
                gender="M"
            else if(btn_female.isChecked)
                gender="F"

            fun checkValidation(
            ): Boolean {
                when {
                    TextUtils.isEmpty(first_name) -> {
                        textFirstName.error = "Field is required"
                        textFirstName.requestFocus()
                        return false
                    }
                    TextUtils.isEmpty(last_name) -> {
                        textLastName.error = "Field is required"
                        textLastName.requestFocus()
                        return false
                    }
                    TextUtils.isEmpty(email) -> {
                        textEmail.error = "Field is required"
                        textEmail.requestFocus()
                        return false
                    }
                    TextUtils.isEmpty(password) -> {
                        textPassword.error = "Field is required"
                        textPassword.requestFocus()
                        return false
                    }
                    TextUtils.isEmpty(confirm_password) -> {
                        textConfirmPassword.error = "Field is required"
                        textConfirmPassword.requestFocus()
                        return false
                    }
                    TextUtils.isEmpty(textPhoneNumber.text.toString()) -> {
                        textPhoneNumber.error = "Field is required"
                        return false
                    }
                    else -> return true
                }
            }



            val check: Boolean = checkValidation()



            if (check) {
                val phone_no: Number = textPhoneNumber.text.toString().trim().toLong()
                ApiManager.getClient().create(Api::class.java)
                    .userCreate(first_name, last_name, email, password, confirm_password, phone_no,gender)
                    .enqueue(object : Callback<LoginResponse> {
                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                            showMessage("registration  failed")
                        }

                        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) =
                            if(response.body()!=null)
                            {
                                showMessage("Registration Sucessful")
                             }
 else
                            {
                                showMessage("Registration Failed")
                            }
                    })
            }
        }
    }
}









