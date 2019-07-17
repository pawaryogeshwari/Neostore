package com.example.neostore_app.Product

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.example.neostore_app.Api
import com.example.neostore_app.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


class ProductPresenter(view: ProductContract.View, context: Context) : ProductContract.Presenter {
    private var myadapter: Myadapter? = null
    var context: Context? = null
    var mview: ProductContract.View? = null
    lateinit var mRecyclerView : RecyclerView

    init {
        this.mview = view
        this.context = context


    }


    fun setAdapter(mRecyclerView: RecyclerView) {
        this.mRecyclerView = mRecyclerView

    }

    override fun productList(product_category_id: String, limit: String, page: String) {
        ApiManager.getClient().create(Api::class.java)
            .productDetails(product_category_id, limit, page).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {

                    if (it != null) {

                        myadapter = Myadapter(it.data)
                        mRecyclerView.adapter = myadapter



                    }
                },
                onError = {
                    mview?.getProduct("category doesn't Exist")
                },
                onComplete = {
                    mview?.getProduct("Category Exist")
                }


            )


    }


    override fun start() {


    }

    override fun stop() {


    }


}