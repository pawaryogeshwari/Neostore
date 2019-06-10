package com.example.neostore_app

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity()
{
override var getLayout=R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolBar("NeoSTORE")


    }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_search, menu)
            return super.onCreateOptionsMenu(menu)
        }


    }



