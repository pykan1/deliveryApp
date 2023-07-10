package com.example.deliveryapp.presentation.screen.category

import android.content.Context
import android.util.Log
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.deliveryapp.data.api.model.AccessTokenModel
import com.example.deliveryapp.data.api.remoteDataSource.BuyerRemoteDataSource
import com.example.deliveryapp.data.datastore.DataStoreManager
import com.example.deliveryapp.domain.usecase.GetAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
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
        viewModelScope.launch {
            stateCategory.update { state ->
                state.copy(isLoading = true)
            }
            GetAccessTokenUseCase().invoke(context).let {
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