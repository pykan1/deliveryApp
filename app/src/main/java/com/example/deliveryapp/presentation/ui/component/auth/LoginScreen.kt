package com.example.deliveryapp.presentation.ui.component.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.deliveryapp.presentation.screen.auth.AuthViewModel

@Composable
fun LoginScreen(viewModel: AuthViewModel) {
    val stateAuth = viewModel.stateAuth.collectAsState()


}