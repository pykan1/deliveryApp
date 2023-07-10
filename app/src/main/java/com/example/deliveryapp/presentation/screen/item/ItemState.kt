package com.example.deliveryapp.presentation.screen.item

import androidx.compose.ui.graphics.ImageBitmap
import com.example.deliveryapp.domain.model.ReviewModel
import java.util.UUID

data class ItemState(
    val id_item: UUID = UUID.randomUUID(),
    val id_category: Int = 0,
    val name: String = "",
    val description: String = "",
    val reviews: List<ReviewModel> = emptyList(),
    val amount: Int = 0,
    val rate: Float = 0.0F,
    val cost: Int = 0,
    val decodeImg: ImageBitmap? = null
)