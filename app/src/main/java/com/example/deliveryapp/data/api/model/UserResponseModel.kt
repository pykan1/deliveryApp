package com.example.deliveryapp.data.api.model

import com.example.deliveryapp.domain.model.ReviewModel
import java.util.UUID

data class UserResponseModel (
    val id_person: UUID,
    val number: String,
    val login: String,
    val role: Int,
    val favorite: List<String>,
    val basket: List<String>,
    val reviews: List<ReviewModel>,
    val access_token: String,
    val refresh_token: String
    )