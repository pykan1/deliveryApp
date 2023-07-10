package com.example.deliveryapp.presentation.screen.item

import android.content.Context
import com.example.deliveryapp.domain.model.ItemModel

interface ItemEvent

class InitItemEvent(val itemModel: ItemModel) : ItemEvent

class AddItemFavoriteEvent(val context: Context) : ItemEvent

class AddItemBasketEvent(val context: Context) : ItemEvent

class DeleteItemFavoriteEvent(val context: Context) : ItemEvent

class DeleteItemBasketEvent(val context: Context) : ItemEvent