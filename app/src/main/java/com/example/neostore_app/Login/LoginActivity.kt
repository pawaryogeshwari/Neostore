package com.example.neostore_app.Login

import android.content.Intent
import android.os.Bundle
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import com.example.neostore_app.activitity.RegistrationActivity
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginActivity : BaseActivity(), LoginContract.View {


    var  presnter = LoginPresnter(this)

    override val getPresenter: BasePresenter
        get() = presnter


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

            if(isValidate)
            {
                presnter.login(email, password)
            }


        }

    }

    override fun showPasswordError() {
        passwordText.error = "password required"
        passwordText.requestFocus()
    }

    override fun showEmailError() {
        email_add.error = "email required"
        email_add.requestFocus()
    }



    override fun loginSucess(message:String) {
        showMessage("Login Sucessful")
    }

    override fun loginFailure(message: String) {
        showMessage("Login Failed")
    }





}