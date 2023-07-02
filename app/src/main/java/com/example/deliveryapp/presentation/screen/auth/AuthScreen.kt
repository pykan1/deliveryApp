package com.example.deliveryapp.presentation.screen.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.deliveryapp.R
import com.example.deliveryapp.presentation.ui.component.auth.LoginScreen
import com.example.deliveryapp.presentation.ui.component.auth.NumberScreen
import com.example.deliveryapp.presentation.ui.component.auth.RegisterScreen


@Composable
fun AuthScreen(navController: NavController) {
    val viewModel = hiltViewModel<AuthViewModel>()
    val stateAuth = viewModel.stateAuth.collectAsState()
    Box(modifier = Modifier.fillMaxSize()) {
        val composition = rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.background))
        val progress by animateLottieCompositionAsState(
            composition = composition.value,
            iterations = LottieConstants.IterateForever
        )
        LottieAnimation(
            modifier = Modifier.fillMaxSize(),
            composition = composition.value,
            progress = { progress }
        )
        when (stateAuth.value.screen) {
            "number" -> {
                NumberScreen(viewModel = viewModel)
            }

            "login" -> {
                LoginScreen(viewModel = viewModel, navController)
            }

            "register" -> {
                RegisterScreen(viewModel = viewModel, navController)
            }
        }
    }
}