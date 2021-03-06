package com.example.neostore_app.Product

import com.example.neostore_app.BasePresenter
import com.example.neostore_app.BaseView

class ProductContract {
    interface View:BaseView
    {
       fun  setAdapter(product : ProductResponse)
       fun  getProduct(message:String)
    }

    interface Presenter:BasePresenter{
        fun productList(product_category_id:String,limit:String,page:String)
    }
}