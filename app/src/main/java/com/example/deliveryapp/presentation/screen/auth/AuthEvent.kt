package com.example.deliveryapp.presentation.screen.auth

import android.content.Context
import androidx.compose.runtime.Immutable
import androidx.navigation.NavController
import com.example.deliveryapp.presentation.screen.base.UiEvent

@Immutable
sealed class AuthEvent : UiEvent {


    data class ChangeLoginEvent(val login: String) : AuthEvent()

    data class ChangePasswordEvent(val password: String) : AuthEvent()

    data class ChangePassword2Event(val password2: String) : AuthEvent()

    data class ChangeNumberEvent(val number: String) : AuthEvent()

    object CheckNumberEvent : AuthEvent()

    data class LoginEvent(val context: Context, val navController: NavController) : AuthEvent()

    data class RegisterEvent(val context: Context, val navController: NavController) : AuthEvent()
}