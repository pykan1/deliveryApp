package com.example.deliveryapp.presentation.screen.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.data.api.model.GetItemsByCategoryModel
import com.example.deliveryapp.data.api.remoteDataSource.BuyerRemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val buyerRemoteDataSource: BuyerRemoteDataSource
): ViewModel() {
    val stateItems = MutableStateFlow(ItemsState())

    fun send(event: ItemsEvent) {
        when(event) {
            is GetItemsByCategoryEvent -> {
                getItemsByCategory(event.id_category)
            }
        }
    }

    private fun getItemsByCategory(idCategory: Int) {
        viewModelScope.launch {
        buyerRemoteDataSource.getItemsByCategory(GetItemsByCategoryModel(
            access_token = ,
            id_category = idCategory
        )). let {
            stateItems.emit(ItemsState())
        }}
    }
}