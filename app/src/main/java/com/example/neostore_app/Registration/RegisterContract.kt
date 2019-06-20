package com.example.neostore_app.Registration

import com.example.neostore_app.BasePresenter

interface RegisterContract {
    interface view
    {
       fun registrationSucess(message:String)
        fun registrationFailure(message: String)
        fun showFnameError()
        fun showLnameError()
        fun showEmailError()
        fun showPasswordError()
        fun showConfirmPwdError()
        fun  showPhonenoError()


    }
    interface presenter:BasePresenter
    {
      fun register(first_name:String,last_name:String,email:String,password:String,confirm_password:String,phone_no:Long,gender:String)
      fun validation(
          first_name:String,
          last_name:String,
          email:String,
          password:String,
          confirm_password:String,
          phone_no: String,
          gender:String):Boolean

    }
}
