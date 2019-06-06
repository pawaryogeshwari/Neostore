package com.example.neostore_app

import android.os.Bundle
import android.view.Menu

class HomeActivity : BaseActivity()
{
override var getLayout=R.layout.activity_home
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        val inflater=menuInflater
        inflater.inflate(R.menu.menu_main,menu)
        return true
    }
}
