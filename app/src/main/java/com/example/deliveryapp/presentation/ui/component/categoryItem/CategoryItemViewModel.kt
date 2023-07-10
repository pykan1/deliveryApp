package com.example.deliveryapp.presentation.ui.component.categoryItem

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.deliveryapp.domain.usecase.DecodeBase64ImageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.Base64

class CategoryItemViewModel : ViewModel() {
    val stateCategoryItem = MutableStateFlow(CategoryItemState())

    fun send(event: CategoryItemEvent) {
        when (event) {
            is InitDataEvent -> {
                initData(event.title, event.img, event.id_category)
            }

            is OpenCategoriesItemsEvent -> {
                openCategoriseItems(event.navController)
            }
        }

    }

    private fun initData(title: String, img: String? = null, id_category: Int) {
        Log.d("11","initData")
        viewModelScope.launch {
            DecodeBase64ImageUseCase().invoke(img)?.let {
                stateCategoryItem.emit(
                    CategoryItemState(
                        isLoading = false,
                        title = title,
                        id_category = id_category,
                        img = img,
                        decodeImg = it.asImageBitmap()
                    )
                )
            }
        }
    }


    private fun openCategoriseItems(navController: NavController) {
        navController.navigate(
            "items/${stateCategoryItem.value.id_category}"
        )
    }
}

