package com.example.deliveryapp.presentation.screen.item

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.deliveryapp.domain.model.ItemModel

@Composable
fun ItemSmallItem(itemModel: ItemModel) {

    val viewModel = hiltViewModel<ItemViewModel>()

    LaunchedEffect(Unit) {
        viewModel.send(InitItemEvent(itemModel))
    }

}