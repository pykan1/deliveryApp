package com.example.deliveryapp.presentation.screen.items

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun ItemsScreen(navController: NavController, idCategory: Int) {
    val context = LocalContext.current
    val viewModel = hiltViewModel<ItemsViewModel>()

    LaunchedEffect(Unit) {
        viewModel.send(GetItemsByCategoryEvent(idCategory, context))
    }



}