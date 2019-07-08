package com.example.neostore_app.Product

import com.example.neostore_app.BasePresenter
import com.example.neostore_app.BaseView

class ProductContract {
    interface View:BaseView
    {
       fun  getProduct(message:String)
    }

    interface Presenter:BasePresenter{
        fun ProductList(product_category_id:String,limit:Number,page:Number)
    }
}