package com.example.deliveryapp.presentation.screen.auth

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.deliveryapp.presentation.screen.base.UiState


@Immutable
data class AuthState (
    val isLoading: Boolean = false,
    var login: MutableState<String> = mutableStateOf(""),
    var password: MutableState<String> = mutableStateOf(""),
    var number: MutableState<String> = mutableStateOf(""),
    var password2: MutableState<String> = mutableStateOf(""),
    val screen: String = "number", //and login and register
    val exception: String = ""
    ): UiState