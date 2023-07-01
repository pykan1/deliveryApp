package com.example.deliveryapp.presentation.screen.auth

import android.content.Context
import androidx.navigation.NavController

interface AuthEvent

class ChangeLoginEvent(val login: String): AuthEvent

class ChangePasswordEvent(val password: String): AuthEvent

class ChangePassword2Event(val password2: String): AuthEvent

class ChangeNumberEvent(val number: String): AuthEvent

class CheckNumberEvent(): AuthEvent

class LoginEvent(val context: Context, val navController: NavController): AuthEvent

class RegisterEvent(val context: Context, val navController: NavController): AuthEvent