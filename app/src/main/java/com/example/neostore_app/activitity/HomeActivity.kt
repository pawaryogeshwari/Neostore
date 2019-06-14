package com.example.neostore_app.activitity

import android.os.Bundle
import android.view.Menu
import com.example.neostore_app.R

class HomeActivity : BaseActivity()
{
override var getLayout= R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolBar("NeoSTORE")


    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_search, menu)
            return super.onCreateOptionsMenu(menu)
        }


    }



