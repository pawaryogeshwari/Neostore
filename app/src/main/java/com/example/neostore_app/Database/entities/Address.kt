package com.example.neostore_app.Database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Address")
data class Address (

    @PrimaryKey(autoGenerate = true)
    var id: Int,
@ColumnInfo(name = "ADDRESS")var address:String,
@ColumnInfo(name = "CITY")var  city:String,
@ColumnInfo(name = "STATE")var state:String,
@ColumnInfo(name = "ZIP CODE")var zipcode:String,
@ColumnInfo(name = "COUNTRY")var country:String

)