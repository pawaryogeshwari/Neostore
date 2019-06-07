package com.example.neostore_app

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginActivity :BaseActivity() {

    override var getLayout = R.layout.activity_login_screen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_login.setOnClickListener{
            val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intent)
        }

        txt_forgotpwd.setOnClickListener {
            val intent1 = Intent(this@LoginActivity, ForgotpwdActivity::class.java)
            startActivity(intent1)
        }
    }
}