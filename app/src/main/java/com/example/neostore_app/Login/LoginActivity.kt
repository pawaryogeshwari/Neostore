package com.example.neostore_app.Login

import android.content.Intent
import android.os.Bundle
import com.example.neostore_app.BasePresenter
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import com.example.neostore_app.Registration.RegistrationActivity
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_login_screen.*

class LoginActivity : BaseActivity(), LoginContract.View {
//    override var mDisposable: Disposable
//        get() = mDisposable
//        set(value) {}


    var  presenter = LoginPresnter(this)


    override val getPresenter: BasePresenter
        get() = presenter




    override var getLayout = R.layout.activity_login_screen



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvSignUp.setOnClickListener {
            val intent1 = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intent1)
        }


        btn_login.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            val isValidate: Boolean = presenter.validateData(email, password)

            if(isValidate)
            {
                presenter.login(email, password)
            }


        }

    }

    override fun showPasswordError() {
        etPassword.error = "password required"
      etPassword.requestFocus()
    }

    override fun showEmailError() {
       etEmail.error = "email required"
        etEmail.requestFocus()
    }



    override fun loginSucess(message:String) {
        showMessage(message)
    }

    override fun loginFailure(message: String) {
        showMessage(message)
    }

}