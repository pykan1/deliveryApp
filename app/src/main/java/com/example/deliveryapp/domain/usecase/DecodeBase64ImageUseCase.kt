package com.example.deliveryapp.domain.usecase

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.util.Base64

class DecodeBase64ImageUseCase {
    fun invoke(img: String? = null): Bitmap? {
        if (img == null) {
            return null
        }
        return try {
            val base64Decoder = Base64.getDecoder()
            val decodedBytes = base64Decoder.decode(img)

            BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}