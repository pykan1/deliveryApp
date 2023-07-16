package com.example.deliveryapp.presentation.screen.auth

import androidx.compose.runtime.Immutable
import com.example.deliveryapp.presentation.screen.base.UiState


@Immutable
data class AuthState (
    val isLoading: Boolean = false,
    val login: String = "",
    val password: String = "",
    val number: String = "",
    val password2: String = "",
    val screen: String = "number", //and login and register
    val exception: String = ""
    ): UiState