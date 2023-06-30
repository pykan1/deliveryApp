package com.example.deliveryapp.data.local.repository

import androidx.room.Dao
import androidx.room.Query
import com.example.deliveryapp.data.local.model.UserModel

@Dao
interface UserRepository {

    @Query("select * from user")
    suspend fun getUser(): UserModel

    @Query("delete from user")
    suspend fun deleteUser()

}