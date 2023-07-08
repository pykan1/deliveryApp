package com.example.deliveryapp.presentation.ui.component.category

import androidx.compose.ui.graphics.ImageBitmap

data class CategoryItemState(
    val isLoading: Boolean = false,
    val title: String = "",
    val id_category: Int = 0,
    val img: String? = null,
    val decodeImg: ImageBitmap? = null
)