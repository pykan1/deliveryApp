package com.example.deliveryapp.data.api.remoteDataSource

import com.example.deliveryapp.data.api.apiService.AuthService
import com.example.deliveryapp.data.api.model.AuthModel
import com.example.deliveryapp.data.api.model.NumberModel
import com.example.deliveryapp.data.api.model.RefreshTokenModel
import com.example.deliveryapp.data.api.model.RegModel
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authService: AuthService
){
    suspend fun login(authModel: AuthModel) = authService.login(authModel)

    suspend fun register(regModel: RegModel) = authService.register(regModel)

    suspend fun updateAccessToken(refreshTokenModel: RefreshTokenModel) = authService.updateAccessToken(refreshTokenModel)

    suspend fun checkNumber(numberModel: NumberModel) = authService.checkNumber(numberModel)
}