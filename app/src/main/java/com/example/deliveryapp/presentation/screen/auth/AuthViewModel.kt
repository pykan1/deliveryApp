package com.example.deliveryapp.presentation.screen.auth

import android.accessibilityservice.AccessibilityService.ScreenshotResult
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.deliveryapp.data.api.model.AuthModel
import com.example.deliveryapp.data.api.model.NumberModel
import com.example.deliveryapp.data.api.model.RegModel
import com.example.deliveryapp.data.api.remoteDataSource.AuthRemoteDataSource
import com.example.deliveryapp.data.datastore.DataStoreManager
import com.example.deliveryapp.data.datastore.model.UserDataStoreModel
import com.example.deliveryapp.data.local.model.UserModel
import com.example.deliveryapp.data.local.repositoryImpl.UserRepositoryImpl
import com.example.deliveryapp.presentation.navigation.Screens
import com.example.deliveryapp.presentation.screen.base.BaseViewModel
import com.example.deliveryapp.presentation.screen.base.Reducer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepositoryImpl: UserRepositoryImpl,
    private val authRemoteDataSource: AuthRemoteDataSource
) : BaseViewModel<AuthState, AuthEvent>() {

    private val reducer = AuthReducer(
        initial = AuthState(),
        viewModelScope = viewModelScope,
        userRepositoryImpl = userRepositoryImpl,
        authRemoteDataSource = authRemoteDataSource
    )

    override val state: StateFlow<AuthState>
        get() = reducer.state

    fun send(event: AuthEvent) {
        reducer.sendEvent(event)
    }




}