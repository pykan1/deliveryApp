package com.example.deliveryapp.data.api.model

import com.example.deliveryapp.domain.model.ItemModel

data class OrderModel(
    val coordinates: String,
    val item: ItemModel,
    val time: String,
    val access_token: String
)