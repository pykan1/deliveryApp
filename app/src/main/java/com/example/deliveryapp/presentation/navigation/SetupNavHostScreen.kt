package com.example.deliveryapp.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetupNavHostScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<NavigationViewModel>()
    val stateNavigation = viewModel.stateNavigation.collectAsState()
    viewModel.send(GetUserEvent())
    if (stateNavigation.value.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

    } else {
        Scaffold(
            bottomBar = {
                if (stateNavigation.value.user != null) {
                    BottomBar(navController = navController)
                }
            },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    SetupNavHost(navController = navController, viewModel)
                }
            }
        )
    }
}