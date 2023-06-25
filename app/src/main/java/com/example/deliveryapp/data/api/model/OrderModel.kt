package com.example.deliveryapp.data.api.model

import com.example.deliveryapp.domain.model.ItemModel

class OrderModel(
    coordinates: String,
    item: ItemModel,
    time: String,
    access_token: String
)