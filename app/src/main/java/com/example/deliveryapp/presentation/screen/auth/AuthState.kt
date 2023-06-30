package com.example.deliveryapp.presentation.screen.auth

data class AuthState (
    val isLoading: Boolean = false,
    val login: String = "",
    val password: String = "",
    val number: String = "",
    val number2: String = "",
    )