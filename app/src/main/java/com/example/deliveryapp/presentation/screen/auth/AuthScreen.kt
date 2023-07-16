package com.example.deliveryapp.presentation.screen.auth

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.deliveryapp.R
import com.example.deliveryapp.presentation.ui.component.authItem.LoginScreen
import com.example.deliveryapp.presentation.ui.component.authItem.NumberScreen
import com.example.deliveryapp.presentation.ui.component.authItem.RegisterScreen


@Composable
fun AuthScreen(navController: NavController) {
    Log.d("11", "AuthScreen")
    val viewModel = hiltViewModel<AuthViewModel>()
    val stateAuth by viewModel.state.collectAsState()
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
        when (stateAuth.screen) {
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
        if(stateAuth.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}