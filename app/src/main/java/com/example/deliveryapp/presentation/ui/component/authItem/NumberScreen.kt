package com.example.deliveryapp.presentation.ui.component.authItem

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deliveryapp.presentation.screen.auth.AuthViewModel
import com.example.deliveryapp.presentation.screen.auth.ChangeNumberEvent
import com.example.deliveryapp.presentation.screen.auth.CheckNumberEvent
import com.example.deliveryapp.presentation.ui.theme.ButtonColor
import com.example.deliveryapp.presentation.ui.theme.TextFieldColor

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NumberScreen(viewModel: AuthViewModel) {
    val stateAuth = viewModel.stateAuth.collectAsState()
    val localFocusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier = Modifier
        .background(color = Color.Transparent)
        .pointerInput(Unit) {
        detectTapGestures(onTap = {
            localFocusManager.clearFocus()
        })
    }.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(color = Color.Transparent),
            contentAlignment = Alignment.BottomCenter
        ) {
            TextField(
                value = stateAuth.value.number,
                onValueChange = { viewModel.send(event = ChangeNumberEvent(it)) },
                label = { Text(text = "Номер телефона...") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = TextFieldColor
                ),
                textStyle = TextStyle(fontSize = 18.sp),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(color = Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    keyboardController?.hide()
                    viewModel.send(event = CheckNumberEvent())
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonColor,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .padding(start = 80.dp, end = 80.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
            ) {
                Text(
                    text = "Дальше",
                    fontSize = 20.sp
                )
            }
        }

    }
}