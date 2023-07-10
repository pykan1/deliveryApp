package com.example.deliveryapp.domain.usecase

import android.content.Context
import com.example.deliveryapp.data.datastore.DataStoreManager
import kotlinx.coroutines.flow.first

class GetAccessTokenUseCase {
     suspend fun invoke(context: Context): String {
        val dataStoreManager = DataStoreManager(context)
        return dataStoreManager.getAccessToken().first()
    }
}