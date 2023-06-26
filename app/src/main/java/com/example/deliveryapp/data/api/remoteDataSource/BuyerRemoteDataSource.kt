package com.example.deliveryapp.data.api.remoteDataSource

import com.example.deliveryapp.data.api.apiService.BuyerService
import com.example.deliveryapp.data.api.model.AccessTokenModel
import com.example.deliveryapp.data.api.model.AddReviewModel
import com.example.deliveryapp.data.api.model.GetItemModel
import javax.inject.Inject

class BuyerRemoteDataSource @Inject constructor(
    private val buyerService: BuyerService
) {
    suspend fun addFavoriteItem(getItemModel: GetItemModel) = buyerService.addFavoriteItem(getItemModel)

    suspend fun deleteFavoriteItem(getItemModel: GetItemModel) = buyerService.deleteFavoriteItem(getItemModel)

    suspend fun addBasketItem(getItemModel: GetItemModel) = buyerService.addBasketItem(getItemModel)

    suspend fun deleteBasketItem(getItemModel: GetItemModel) = buyerService.deleteBasketItem(getItemModel)

    suspend fun addReviewItem(addReviewModel: AddReviewModel) = buyerService.addReviewItem(addReviewModel)

    suspend fun getItems(accessTokenModel: AccessTokenModel) = buyerService.getItems(accessTokenModel)
}