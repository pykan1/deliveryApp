package com.example.deliveryapp.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.deliveryapp.R

@Composable
fun BackgroundLottie(img: LottieCompositionSpec) {
    val composition = rememberLottieComposition(img)
    val progress by animateLottieCompositionAsState(
        composition = composition.value,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        modifier = Modifier.fillMaxSize(),
        composition = composition.value,
        progress = { progress }
    )
}
