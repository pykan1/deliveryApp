package com.example.deliveryapp.presentation.screen.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.data.api.model.AccessTokenModel
import com.example.deliveryapp.data.api.remoteDataSource.BuyerRemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val buyerRemoteDataSource: BuyerRemoteDataSource
): ViewModel() {
    val stateCategory = MutableStateFlow(CategoryState())

    fun send(event: CategoryEvent) {

        when(event) {
            is GetCategoryEvent -> {

            }
        }
    }

    private fun getCategory() {
        viewModelScope.launch {
            stateCategory.emit(
                CategoryState(
                    isLoading = true,
                    categories = stateCategory.value.categories
                )
            )
            val categories = buyerRemoteDataSource.getCategory(AccessTokenModel(access_token = ))
            stateCategory.emit(

            )
        }
    }
}