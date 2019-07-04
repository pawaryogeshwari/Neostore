package com.example.neostore_app.Registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.neostore_app.R
import com.example.neostore_app.activitity.BaseActivity
import com.example.neostore_app.HomeScreen.HomeActivity
import kotlinx.android.synthetic.main.activity_registration.*

import kotlinx.android.synthetic.main.toolbar.*

class RegistrationActivity : BaseActivity(),RegisterContract.view {
//    override var mDisposable: Disposable
//        get() = mDisposable
//        set(value) {}


    var  presenter = RegisterPresenter(this)
    override val getPresenter: RegisterPresenter
        get() = presenter



    override var getLayout = R.layout.activity_registration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(id_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        iv_menu.setVisibility(View.GONE);
        ivSearch.setVisibility(View.GONE)

    tvtitle.setText("Register")

        btn_register.setOnClickListener {

            val intent = Intent(this@RegistrationActivity, HomeActivity::class.java)
            startActivity(intent)

            val first_name = etFirstName.text.toString().trim()
            val last_name = etLastName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirm_password = etConfirmPassword.text.toString()
            val phone_no = etPhoneNumber.text.toString().trim()



            var gender:String=""
            if(btn_male.isChecked)
                gender="M"
            else if(btn_female.isChecked)
                gender="F"






val isvalidate:Boolean = presenter.validation(first_name,last_name,email,password,confirm_password,phone_no,gender)



            if (isvalidate) {

              presenter.register(first_name, last_name, email, password, confirm_password, phone_no.toLong(), gender)



            }
        }
    }

    override fun registrationSucess(message: String) {

        showMessage(message)

    }

    override fun registrationFailure(message: String) {
        showMessage(message)
    }

    override fun showFnameError() {
       etFirstName.error = "Field required"
        etFirstName.requestFocus()
    }

    override fun showLnameError() {
       etLastName.error = "Field required"
      etLastName.requestFocus()
    }

    override fun showConfirmPwdError() {
        etConfirmPassword.error = "password not match"
       etConfirmPassword.requestFocus()
    }

    override fun showPhonenoError() {
      etPhoneNumber.error = "Field required"
      etPhoneNumber.requestFocus()
    }


    override fun showEmailError() {
       etEmail.error = "Email required"
      etEmail.requestFocus()
    }

    override fun showPasswordError() {
       etPassword.error = "password Incorrect"
      etPassword.requestFocus()
    }

}









