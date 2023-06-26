package com.example.deliveryapp.data.api.apiService

import com.example.deliveryapp.data.api.model.AccessTokenModel
import com.example.deliveryapp.data.api.model.AddReviewModel
import com.example.deliveryapp.data.api.model.GetItemModel
import com.example.deliveryapp.domain.model.ItemModel
import retrofit2.http.Body
import retrofit2.http.POST

interface BuyerService {

    @POST("item/add_favorite_item")
    suspend fun addFavoriteItem(@Body request: GetItemModel)

    @POST("/item/delete_favorite_item")
    suspend fun deleteFavoriteItem(@Body request: GetItemModel)

    @POST("item/add_basket_item")
    suspend fun addBasketItem(@Body request: GetItemModel)

    @POST("item/delete_basket_item")
    suspend fun deleteBasketItem(@Body request: GetItemModel)

    @POST("item/add_review_item")
    suspend fun addReviewItem(@Body request: AddReviewModel)

    @POST("item/get_items")
    suspend fun getItems(@Body request: AccessTokenModel)

}