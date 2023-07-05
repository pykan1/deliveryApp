package com.example.deliveryapp.presentation.screen.category

import com.example.deliveryapp.domain.model.CategoryModel

data class CategoryState (
    val isLoading: Boolean = false,
    val categories: List<CategoryModel> = emptyList()
        )