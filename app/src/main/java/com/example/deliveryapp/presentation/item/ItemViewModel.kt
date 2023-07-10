package com.example.deliveryapp.presentation.item

import androidx.lifecycle.ViewModel
import com.example.deliveryapp.data.api.apiService.BuyerService
import com.example.deliveryapp.data.api.remoteDataSource.BuyerRemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ItemViewModel @Inject constructor(
    private val buyerRemoteDataSource: BuyerRemoteDataSource
): ViewModel() {



}