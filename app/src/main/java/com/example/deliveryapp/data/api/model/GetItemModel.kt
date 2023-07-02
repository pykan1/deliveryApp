package com.example.deliveryapp.data.api.model

import java.util.UUID

data class GetItemModel(
    val id_item: UUID,
    val access_token: String
)