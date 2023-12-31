package com.example.deliveryapp.presentation.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.deliveryapp.R
import com.example.deliveryapp.presentation.screen.auth.AuthScreen
import com.example.deliveryapp.presentation.screen.category.CategoryScreen
import com.example.deliveryapp.presentation.screen.item.ItemScreen
import com.example.deliveryapp.presentation.screen.item.ItemState
import com.example.deliveryapp.presentation.screen.items.ItemsScreen
import com.google.gson.Gson

sealed class Screens(val route: String, val icon: Int, val label: String) {
    object Main: Screens(route = "main_screen", icon = R.drawable.cart_icon, label = "Магазин")
    object Auth: Screens(route = "auth_screen", icon = R.drawable.cart_icon, label = "Каталог")
    object Catalog: Screens(route = "catalog_screen", icon = R.drawable.catalog_icon, label = "Каталог")
    object Trash: Screens(route = "trash_screen", icon = R.drawable.basket_icon, label = "Корзина")
    object Profile: Screens(route = "profile_screen", icon = R.drawable.user_icon, label = "Профиль")
    object Items: Screens(route = "items/{id_category}", icon = R.drawable.not_image, label = "Items")
    object Item: Screens(route = "item/{item_state}", icon = R.drawable.not_image, label = "Item")


}


@Composable
fun SetupNavHost(navController: NavHostController, viewModel: NavigationViewModel) {
    val stateNavigation = viewModel.stateNavigation.collectAsState()
    NavHost(navController = navController, startDestination =
    if (stateNavigation.value.user == null)
        Screens.Auth.route
    else
        Screens.Catalog.route
    ) {
        
        composable(route = Screens.Main.route) {

        }

        composable(route = Screens.Auth.route) {
            AuthScreen(navController = navController)
        }

        composable(route = Screens.Catalog.route) {
            CategoryScreen(navController = navController)
        }

        composable(route = Screens.Trash.route) {

        }

        composable(route = Screens.Profile.route) {
            
        }

        composable(route = Screens.Items.route) {
            val idCategory = it.arguments?.getInt("id_category")?.toInt()
            ItemsScreen(navController, idCategory!!)
        }

        composable(route = Screens.Item.route) {
            val stateItemJson = it.arguments?.getString("item_state")
            val stateItem = Gson().fromJson(stateItemJson, ItemState::class.java)
            ItemScreen(navController = navController, itemState = stateItem)
        }
    }
}