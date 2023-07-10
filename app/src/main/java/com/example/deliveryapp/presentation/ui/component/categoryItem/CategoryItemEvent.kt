package com.example.deliveryapp.presentation.ui.component.categoryItem

import androidx.navigation.NavController
import com.example.deliveryapp.presentation.screen.category.CategoryEvent

interface CategoryItemEvent

class LoadingEvent(): CategoryItemEvent

class UnLoadingEvent(): CategoryItemEvent

class LoadingImage(): CategoryItemEvent

class InitDataEvent(val title: String, val img: String? = null, val id_category: Int): CategoryItemEvent

class OpenCategoriesItemsEvent(val navController: NavController): CategoryItemEvent
