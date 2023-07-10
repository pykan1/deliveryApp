package com.example.deliveryapp.presentation.screen.item

import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.data.api.remoteDataSource.BuyerRemoteDataSource
import com.example.deliveryapp.domain.model.ItemModel
import com.example.deliveryapp.domain.usecase.DecodeBase64ImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemViewModel @Inject constructor(
    private val buyerRemoteDataSource: BuyerRemoteDataSource
) : ViewModel() {

    val stateItem = MutableStateFlow(ItemState())

    fun send(event: ItemEvent) {
        when (event) {
            is InitItemEvent -> {
                initItem(event.itemModel)
            }
        }
    }

    private fun initItem(itemModel: ItemModel) {
        viewModelScope.launch {
            stateItem.emit(
                ItemState(
                    id_item = itemModel.id_item,
                    id_category = itemModel.id_category,
                    name = itemModel.name,
                    description = itemModel.description,
                    reviews = itemModel.reviews,
                    amount = itemModel.amount,
                    rate = itemModel.rate,
                    cost = itemModel.cost,
                    decodeImg = DecodeBase64ImageUseCase().invoke(itemModel.img)?.asImageBitmap()
                )
            )
        }
    }



}