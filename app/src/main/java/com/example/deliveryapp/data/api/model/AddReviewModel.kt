package com.example.deliveryapp.data.api.model

import com.example.deliveryapp.domain.model.ReviewModel
import java.util.UUID

data class AddReviewModel(
    val id_item: UUID,
    val review: ReviewModel,
    val access_token: String
)