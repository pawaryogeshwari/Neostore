package com.example.neostore_app.Product

class ProductPresenter(view: ProductContract.View):ProductContract.Presenter
{

    var mview:ProductContract.View? = null

    init {
        mview = view
    }

    override fun ProductList(product_category_id: String, limit: Number, page: Number) {


    }

    override fun start() {


    }

    override fun stop() {

    }



}