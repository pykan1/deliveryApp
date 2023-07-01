package com.example.deliveryapp.presentation.screen.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.deliveryapp.presentation.ui.component.auth.LoginScreen
import com.example.deliveryapp.presentation.ui.component.auth.NumberScreen
import com.example.deliveryapp.presentation.ui.component.auth.RegisterScreen


@Composable
fun AuthScreen(navController: NavController) {
    val viewModel = hiltViewModel<AuthViewModel>()
    val stateAuth = viewModel.stateAuth.collectAsState()

    when (stateAuth.value.screen) {
        "number" -> {
            NumberScreen(viewModel = viewModel)
        }
        "login" -> {
            LoginScreen(viewModel = viewModel)
        }
        "register" -> {
            RegisterScreen(viewModel = viewModel)
        }
    }
}