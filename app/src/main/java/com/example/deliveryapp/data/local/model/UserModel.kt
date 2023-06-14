package com.example.deliveryapp.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "user")
data class UserModel(
    @PrimaryKey(autoGenerate = false)
    val id_person: UUID,
    val id_role: Byte,
    val login: String,
)
