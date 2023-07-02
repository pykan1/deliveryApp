package com.example.deliveryapp.presentation.navigation

import com.example.deliveryapp.data.local.model.UserModel

data class NavigationState(
    val isLoading: Boolean = true,
    val user: UserModel? = null
    )