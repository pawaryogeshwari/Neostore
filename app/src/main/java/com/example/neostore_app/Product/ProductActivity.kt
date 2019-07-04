package com.example.neostore_app.Product

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.neostore_app.R
import kotlinx.android.synthetic.main.toolbar.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        iv_menu.setVisibility(View.GONE);

    }
}
