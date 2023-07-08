package com.example.deliveryapp.presentation.ui.component.category

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.Base64

class CategoryItemViewModel : ViewModel() {
    val stateCategoryItem = MutableStateFlow(CategoryItemState())

    fun send(event: CategoryItemEvent) {
        when (event) {
            is LoadingEvent -> {
                loading()
            }

            is UnLoadingEvent -> {
                unLoading()
            }

            is LoadingImage -> {
                loadingImage()
            }

            is InitDataEvent -> {
                initData(event.title, event.img, event.id_category)
            }
        }

    }

    private fun loading() {
        viewModelScope.launch {
            stateCategoryItem.emit(
                CategoryItemState(
                    isLoading = true,
                    title = stateCategoryItem.value.title,
                    id_category = stateCategoryItem.value.id_category,
                    img = stateCategoryItem.value.img,
                    decodeImg = stateCategoryItem.value.decodeImg
                )
            )
        }
    }

    private fun unLoading() {
        viewModelScope.launch {
            stateCategoryItem.emit(
                CategoryItemState(
                    isLoading = false,
                    title = stateCategoryItem.value.title,
                    id_category = stateCategoryItem.value.id_category,
                    img = stateCategoryItem.value.img,
                    decodeImg = stateCategoryItem.value.decodeImg
                )
            )
        }
    }

    private fun initData(title: String, img: String? = null, id_category: Int) {
        viewModelScope.launch {
            stateCategoryItem.emit(
                CategoryItemState(
                    isLoading = false,
                    title = title,
                    id_category = id_category,
                    img = img,
                    decodeImg = if (img != null) {
                        decodeBase64Image(img)?.asImageBitmap()
                    } else null
                )
            )
        }
    }

    private fun loadingImage() {
        viewModelScope.launch {
            stateCategoryItem.emit(
                CategoryItemState(
                    isLoading = stateCategoryItem.value.isLoading,
                    title = stateCategoryItem.value.title,
                    img = stateCategoryItem.value.img,
                    id_category = stateCategoryItem.value.id_category,
                    decodeImg = if (stateCategoryItem.value.img != null) {
                        decodeBase64Image(
                            stateCategoryItem.value.img!!
                        )?.asImageBitmap()
                    } else null
                )
            )
        }
    }
}

private fun decodeBase64Image(img: String): Bitmap? {
    return try {
        val base64Decoder = Base64.getDecoder()
        val decodedBytes = base64Decoder.decode(img)

        BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
