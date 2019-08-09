package com.example.neostore_app.resetpassword

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.neostore_app.Login.LoginActivity
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_reset_password.*
import kotlinx.android.synthetic.main.toolbar.*

class ResetPasswordActivity : BaseActivity() {
    override val getLayout = R.layout.activity_reset_password

    lateinit var viewModel: ResetPasswordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        iv_menu.visibility = View.GONE

        setToolbar("Reset Password")
        setToolbarAsBack()


        viewModel = ViewModelProviders.of(this).get(ResetPasswordViewModel::class.java)

        btn_reset.setOnClickListener {

            val oldPassword = et_Current_Password.text.toString()
            val password1 = et_Password.text.toString()
            val confirmPwd = et_Confirm_Password.text.toString()


            val settings = getSharedPreferences("LoginDetails", 0)
            val test =settings.getString("access_token", null)
            viewModel.resetPwd(test,oldPassword,password1,confirmPwd)

        }

        viewModel.passwordDataResponse().observe(this, Observer {

            if(it!= null)
            {
                showMessage(it.message)
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
            else
            {
                showMessage("Error")
            }

        })


    }
}
