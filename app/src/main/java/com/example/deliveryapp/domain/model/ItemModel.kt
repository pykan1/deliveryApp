package com.example.deliveryapp.domain.model

import java.util.UUID

data class ItemModel (
    val id_item: UUID = UUID.randomUUID(),
    val id_category: Int = 1,
    val name: String = "",
    val description: String = "",
    val reviews: List<ReviewModel>,
    val amount: Int = 0,
    val rate: Float = 0.0f,
    val cost: Int = 0,
    val img: String = ""
        )