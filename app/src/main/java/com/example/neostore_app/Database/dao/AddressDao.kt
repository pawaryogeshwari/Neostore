package com.example.neostore_app.Database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.neostore_app.Database.entities.Address

@Dao
interface AddressDao {

    @Insert
    fun addAdreess(add:Address)

    @Query("select * From  Address")
    fun getAddress():List<Address>
}