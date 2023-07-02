package com.example.deliveryapp.presentation.ui.component.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.deliveryapp.presentation.screen.auth.AuthViewModel

@Composable
fun RegisterScreen(viewModel: AuthViewModel, navController: NavController) {
    val stateAuth = viewModel.stateAuth.collectAsState()
}