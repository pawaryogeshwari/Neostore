package com.example.neostore_app.DI

import android.app.Application

class DemoApplication :Application(){

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()

    }




        fun getComponent(): AppComponent {

            return appComponent

    }

}