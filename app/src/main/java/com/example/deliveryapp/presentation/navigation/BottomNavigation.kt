package com.example.deliveryapp.presentation.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.deliveryapp.presentation.ui.theme.ButtonColor
import com.example.deliveryapp.presentation.ui.theme.TextFieldColor

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        Screens.Main,
        Screens.Catalog,
        Screens.Trash,
        Screens.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: Screens,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        modifier = Modifier
            .background(color = Color.White)
            .wrapContentSize(),
        icon = {
            Image(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = screen.icon),
                contentDescription = "Navigation Icon"
            )
        },
        label = { Text(text = screen.label) },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = Color.Black,
        selectedContentColor = ButtonColor,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}