package com.example.deliveryapp.presentation.screen.items

import android.content.Context

interface ItemsEvent

class GetItemsByCategoryEvent(val id_category: Int, val context: Context): ItemsEvent

