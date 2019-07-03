package com.example.neostore_app.DI

import com.example.neostore_app.ApiManager
import com.example.neostore_app.Login.LoginPresnter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,ApiManager::class])
interface AppComponent {

    fun inject(target:LoginPresnter)



}