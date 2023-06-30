package com.example.deliveryapp.data.local.repositoryImpl

import com.example.deliveryapp.data.local.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend fun getUser() = userRepository.getUser()

    suspend fun deleteUser() = userRepository.deleteUser()

}