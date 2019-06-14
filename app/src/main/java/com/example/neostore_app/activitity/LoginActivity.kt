package com.example.neostore_app.activitity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.neostore_app.MVP.LoginContract
import com.example.neostore_app.MVP.LoginPresnter
import com.example.neostore_app.R
import com.example.neostore_app.model.Api
import com.example.neostore_app.model.ApiManager
import com.example.neostore_app.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity(), LoginContract.View {

  val presnter = LoginPresnter(this)

    override fun showPasswordError() {
        passwordText.error = "password required"
        passwordText.requestFocus()
    }

    override fun showEmailError() {
        email_add.error = "email required"
        email_add.requestFocus()
    }

    override fun loginSucess() {

    showMessage("Login Sucessful")
    }

    override fun loginFailure() {

        showMessage("Login Failed")
    }




    override var getLayout = R.layout.activity_login_screen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        text_SignUp.setOnClickListener {
            val intent1 = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intent1)
        }


        btn_login.setOnClickListener {
            val email = email_add.text.toString().trim()
            val password = passwordText.text.toString().trim()



            val isValidate: Boolean = presnter.validateData(email, password)

            if (isValidate) {

                ApiManager.getClient().create(Api::class.java)
                    .userLogin(email, password)
                    .enqueue(object : Callback<LoginResponse> {
                        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                            Toast.makeText(this@LoginActivity, t.message, Toast.LENGTH_SHORT).show()
                        }

                        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {


                            if (response.body() != null) {

                                showMessage(response.body()?.message)
                            } else {
                               showMessage("Login Failed")

                            }
                        }
                    })

            }
        }
    }
}