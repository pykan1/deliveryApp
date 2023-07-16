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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.deliveryapp.presentation.screen.auth.AuthEvent
import com.example.deliveryapp.presentation.screen.auth.AuthViewModel
import com.example.deliveryapp.presentation.ui.theme.ButtonColor
import com.example.deliveryapp.presentation.ui.theme.TextFieldColor

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: AuthViewModel, navController: NavController) {
    val stateAuth by viewModel.state.collectAsState()
    val context = LocalContext.current
    val localFocusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Transparent)
        .pointerInput(Unit) {
            detectTapGestures(onTap = {
                localFocusManager.clearFocus()
            })
        }
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(color = Color.Transparent),
            contentAlignment = Alignment.BottomCenter
        ) {
            TextField(
                value = stateAuth.password,
                onValueChange = { viewModel.send(event = AuthEvent.ChangePasswordEvent(it)) },
                label = { Text(text = "Пароль...") },
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
                    viewModel.send(event = AuthEvent.LoginEvent(context, navController))
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
                    text = "Войти",
                    fontSize = 20.sp
                )
            }
        }

    }
}