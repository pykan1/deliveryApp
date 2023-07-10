package com.example.deliveryapp.presentation.screen.items

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.deliveryapp.presentation.screen.item.ItemSmallItem
import com.example.deliveryapp.presentation.ui.component.authItem.LoginScreen
import com.example.deliveryapp.presentation.ui.theme.LightGray


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen(navController: NavController, idCategory: Int) {
    val context = LocalContext.current
    val viewModel = hiltViewModel<ItemsViewModel>()
    val stateItems by viewModel.stateItems.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.send(GetItemsByCategoryEvent(idCategory, context))
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGray),
        topBar = {TopAppBar(
            title = { Text(text = "Категория", fontSize = 12.sp) },
            modifier = Modifier
        )}
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(stateItems.items) {
                Log.d("11", it.toString())
                ItemSmallItem(itemModel = it)
            }
        }
    }

}