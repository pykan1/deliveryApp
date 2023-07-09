package com.example.deliveryapp.presentation.screen.items

import com.example.deliveryapp.domain.model.ItemModel

data class ItemsState (
    val isLoading: Boolean = false,
    val items: List<ItemModel> = emptyList()
        )