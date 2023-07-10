package com.example.deliveryapp.presentation.item

import com.example.deliveryapp.domain.model.ReviewModel

data class ItemState (
    val isLoading: Boolean = false,
    val title: String = "",
    val cost: Int = 0,
    val rate: Int = 0,
    val img: String = "",
    val body: String = "",
    val reviews: List<ReviewModel> = listOf()
)