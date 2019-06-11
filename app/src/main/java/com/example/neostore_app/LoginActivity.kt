package com.example.neostore_app

import android.content.Intent
import android.os.Bundle
import com.example.neostore_app.activitity.BaseActivity
import com.example.neostore_app.model.Api
import com.example.neostore_app.model.ApiManager
import com.example.neostore_app.model.LoginResponse
import kotlinx.android.synthetic.main.activity_login_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {

    override var getLayout = R.layout.activity_login_screen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        txt_forgotpwd.setOnClickListener {
            val intent1 = Intent(this@LoginActivity, ForgotpwdActivity::class.java)
            startActivity(intent1)
        }


        btn_login.setOnClickListener {
            val email = email_add.toString().trim()
            val password = password.toString().trim()


            val api = ApiManager.getClient().create(Api::class.java)
                .userLogin(email, password)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })

        }
    }
}