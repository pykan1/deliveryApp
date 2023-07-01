package com.example.deliveryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.deliveryapp.data.local.model.UserModel
import com.example.deliveryapp.data.local.repository.UserRepository

@Database(entities = [UserModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserRepository
}