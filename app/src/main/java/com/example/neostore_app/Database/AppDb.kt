package com.example.neostore_app.Database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.neostore_app.Database.dao.AddressDao
import com.example.neostore_app.Database.entities.Address

@Database(entities = [(Address::class)],version = 1)
abstract class AppDb:RoomDatabase() {

    abstract fun addressDao():AddressDao


    companion object{

        var sInstance:AppDb? = null

        @Synchronized
        fun getInstance(context: Context): AppDb {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context.applicationContext, AppDb::class.java, "example")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return sInstance!!
        }

    }
}
