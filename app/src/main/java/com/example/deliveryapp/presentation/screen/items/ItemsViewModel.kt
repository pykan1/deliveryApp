package com.example.deliveryapp.presentation.screen.items

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.data.api.model.GetItemsByCategoryModel
import com.example.deliveryapp.data.api.remoteDataSource.BuyerRemoteDataSource
import com.example.deliveryapp.data.datastore.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val buyerRemoteDataSource: BuyerRemoteDataSource
) : ViewModel() {
    val stateItems = MutableStateFlow(ItemsState())

    fun send(event: ItemsEvent) {
        when (event) {
            is GetItemsByCategoryEvent -> {
                getItemsByCategory(event.id_category, event.context)
            }
        }
    }

    private fun getItemsByCategory(idCategory: Int, context: Context) {
        viewModelScope.launch {
            val dataStoreManager = DataStoreManager(context)
            buyerRemoteDataSource.getItemsByCategory(
                GetItemsByCategoryModel(
                    access_token = dataStoreManager.getAccessToken().first(),
                    id_category = idCategory
                )
            ).let {
                stateItems.emit(ItemsState(
                    isLoading = stateItems.value.isLoading,
                    items = it
                ))
            }
        }
    }


}