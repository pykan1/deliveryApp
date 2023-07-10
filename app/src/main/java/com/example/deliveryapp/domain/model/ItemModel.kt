package com.example.deliveryapp.domain.model

import java.util.UUID

data class ItemModel (
    val id_item: UUID,
    val id_category: Int,
    val name: String,
    val description: String,
    val reviews: List<ReviewModel>,
    val amount: Int,
    val rate: Float,
    val cost: Int,
    val img: String
        )