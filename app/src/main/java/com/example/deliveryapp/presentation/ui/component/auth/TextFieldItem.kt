package com.example.deliveryapp.presentation.ui.component.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.presentation.screen.auth.AuthEvent
import com.example.deliveryapp.presentation.screen.auth.AuthViewModel
import com.example.deliveryapp.presentation.screen.auth.ChangePasswordEvent
import com.example.deliveryapp.presentation.ui.theme.TextFieldColor

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun TextFieldItem(value: String, viewModel: AuthViewModel, event: Any) {
//    TextField(
//        value = value,
//        onValueChange = { viewModel.send(event = event(it)) },
//        label = { Text(text = "Пароль...") },
//        colors = TextFieldDefaults.textFieldColors(
//            textColor = Color.Black,
//            containerColor = TextFieldColor
//        ),
//        textStyle = TextStyle(fontSize = 18.sp),
//        singleLine = true,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 50.dp)
//            .clip(RoundedCornerShape(20.dp))
//    )
//}