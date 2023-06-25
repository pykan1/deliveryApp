package com.example.deliveryapp.data.api.model

import com.example.deliveryapp.domain.model.ReviewModel
import java.util.UUID

class AddReviewModel(
    id_item: UUID,
    review: ReviewModel,
    access_token: String
)