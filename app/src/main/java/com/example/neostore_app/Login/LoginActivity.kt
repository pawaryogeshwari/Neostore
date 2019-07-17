package com.example.neostore_app.Login


import android.content.Intent
import android.os.Bundle
import com.example.neostore_app.EMAIL
import com.example.neostore_app.HomeScreen.HomeActivity
import com.example.neostore_app.LOGGEDIN
import com.example.neostore_app.PASSWORD
import com.example.neostore_app.R
import com.example.neostore_app.Registration.RegistrationActivity
import com.example.neostore_app.activitity.BaseActivity
import kotlinx.android.synthetic.main.activity_login_screen.*


class LoginActivity : BaseActivity(), LoginContract.View {

//    override var mDisposable: Disposable
//        get() = mDisposable
//        set(value) {}


    var presenter = LoginPresnter(this)
    private var EMPTY = ""




    override val getLayout = R.layout.activity_login_screen


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val settings = getSharedPreferences("LoginDetails", 0)
        val isLoggedIn = settings.getBoolean(LOGGEDIN, false)


        if(isLoggedIn )
        {

            val email = settings.getString(EMAIL,EMPTY)
            val password = settings.getString(PASSWORD,EMPTY)

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)


        }



        ivSignup.setOnClickListener {
            val intent1 = Intent(this@LoginActivity, RegistrationActivity::class.java)
            startActivity(intent1)
        }






        btn_login.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()


            val isValidate: Boolean = presenter.validateData(email, password)

            if (isValidate) {

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


    override fun loginSucess() {

        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        val settings = getSharedPreferences("LoginDetails", 0)
        val editor = settings.edit()
        editor.putString(EMAIL,email)
        editor.putString(PASSWORD,password)
        editor.putBoolean(LOGGEDIN, true)
        editor.apply()
        etEmail.setText(email)
        etPassword.setText(password)

        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()

    }

    override fun loginSucessMessage(message: String) {

        showMessage(message)
    }

    override fun loginFailure(message: String) {
        showMessage(message)
    }

}