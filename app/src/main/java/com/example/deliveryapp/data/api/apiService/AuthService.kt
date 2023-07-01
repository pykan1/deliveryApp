package com.example.deliveryapp.data.api.apiService

import com.example.deliveryapp.data.api.model.AuthModel
import com.example.deliveryapp.data.api.model.NumberModel
import com.example.deliveryapp.data.api.model.RefreshTokenModel
import com.example.deliveryapp.data.api.model.RegModel
import com.example.deliveryapp.data.api.model.UserResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("login")
    suspend fun login(@Body request: AuthModel): UserResponseModel

    @POST("register")
    suspend fun register(@Body request: RegModel): UserResponseModel

    @POST("update_access_token")
    suspend fun updateAccessToken(@Body request: RefreshTokenModel): String

    @POST("check_number")
    suspend fun checkNumber(@Body request: NumberModel): Boolean


}