package com.example.deliveryapp.domain.usecase

import com.example.deliveryapp.data.local.repositoryImpl.UserRepositoryImpl
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepositoryImpl: UserRepositoryImpl
) {
    suspend fun invoke() = userRepositoryImpl.getUser()
}