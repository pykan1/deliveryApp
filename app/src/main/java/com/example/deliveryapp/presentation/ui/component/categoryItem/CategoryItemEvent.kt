package com.example.deliveryapp.presentation.ui.component.categoryItem

interface CategoryItemEvent

class LoadingEvent(): CategoryItemEvent

class UnLoadingEvent(): CategoryItemEvent

class LoadingImage(): CategoryItemEvent

class InitDataEvent(val title: String, val img: String? = null, val id_category: Int): CategoryItemEvent
