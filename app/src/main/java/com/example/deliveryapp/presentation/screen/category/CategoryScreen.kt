package com.example.deliveryapp.presentation.screen.category

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.deliveryapp.presentation.ui.component.LoadingIndicator
import com.example.deliveryapp.presentation.ui.component.categoryItem.CategoryItem


@Composable
fun CategoryScreen(navController: NavController) {
    Log.d("11", "catalog")
    val context = LocalContext.current
    val viewModel = hiltViewModel<CategoryViewModel>()
    val stateCategory by viewModel.stateCategory.collectAsState()
    Log.d("11", "CategoryScreen")
    LaunchedEffect(Unit) {
        viewModel.send(GetCategoryEvent(context))
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(stateCategory.categories) { cat ->
            CategoryItem(
                navController = navController,
                model = cat
            )
        }
    }
}