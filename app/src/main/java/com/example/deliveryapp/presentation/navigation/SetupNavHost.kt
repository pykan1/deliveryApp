package com.example.deliveryapp.presentation.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.deliveryapp.R
import com.example.deliveryapp.presentation.screen.auth.AuthScreen

sealed class Screens(val route: String, val icon: Int) {
    object Main: Screens(route = "main_screen", icon = R.drawable.cart_icon)
    object Auth: Screens(route = "auth_screen", icon = R.drawable.cart_icon)
    object Catalog: Screens(route = "catalog_screen", icon = R.drawable.catalog_icon)
    object Trash: Screens(route = "trash_screen", icon = R.drawable.basket_icon)
    object Profile: Screens(route = "profile_screen", icon = R.drawable.user_icon)
}


@Composable
fun SetupNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Auth.route) {
        
        composable(route = Screens.Main.route) {

        }

        composable(route = Screens.Auth.route) {
            AuthScreen(navController = navController)
        }

        composable(route = Screens.Catalog.route) {

        }

        composable(route = Screens.Trash.route) {

        }

        composable(route = Screens.Profile.route) {
            
        }
    }
}