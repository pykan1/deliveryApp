package com.example.deliveryapp.presentation.screen.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.deliveryapp.presentation.ui.component.category.CategoryItem


@Composable
fun CategoryScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel = hiltViewModel<CategoryViewModel>()
    val stateCategory = viewModel.stateCategory.collectAsState()
    viewModel.send(GetCategoryEvent(context))
    LazyColumn(
        modifier = Modifier.padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        itemsIndexed(
            stateCategory.value.categories
        ) {_, cat ->
            CategoryItem(navController = navController, categoryViewModel = viewModel, model = cat)
        }

    }
}