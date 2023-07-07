package com.example.deliveryapp.presentation.screen.category

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.data.api.model.AccessTokenModel
import com.example.deliveryapp.data.api.remoteDataSource.BuyerRemoteDataSource
import com.example.deliveryapp.data.datastore.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val buyerRemoteDataSource: BuyerRemoteDataSource
) : ViewModel() {
    val stateCategory = MutableStateFlow(CategoryState())

    fun send(event: CategoryEvent) {

        when (event) {
            is GetCategoryEvent -> {
                getCategory(event.context)
            }
        }
    }

    private fun getCategory(context: Context) {
        val dataStoreManager = DataStoreManager(context)
        viewModelScope.launch {
            stateCategory.emit(
                CategoryState(
                    isLoading = true,
                    categories = stateCategory.value.categories
                )
            )
            val accessToken = dataStoreManager.getAccessToken().first().let {
                Log.d("11", it.toString())
                buyerRemoteDataSource.getCategory(
                    AccessTokenModel(
                        access_token = it
                    )
                ).let { model ->
                    Log.d("11", model.toString())
                    stateCategory.emit(
                        CategoryState(
                            isLoading = false,
                            categories = model
                        )
                    )
                }
            }
        }
    }
}