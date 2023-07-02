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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepositoryImpl: UserRepositoryImpl,
    private val authRemoteDataSource: AuthRemoteDataSource
) : ViewModel() {

    val stateAuth = MutableStateFlow(AuthState())

    fun send(event: AuthEvent) {
        when (event) {
            is ChangeLoginEvent -> {
                changeLogin(event)
            }

            is ChangePasswordEvent -> {
                changePassword(event)
            }

            is ChangePassword2Event -> {
                changePassword2(event)
            }

            is ChangeNumberEvent -> {
                changeNumber(event)
            }

            is CheckNumberEvent -> {
                checkNumber()
            }

            is LoginEvent -> {
                login(event.context, event.navController)
            }

            is RegisterEvent -> {
                register(event.context, event.navController)
            }
        }
    }

    private fun changeLogin(event: ChangeLoginEvent) {
        viewModelScope.launch {
            stateAuth.emit(
                AuthState(
                    isLoading = stateAuth.value.isLoading,
                    login = event.login,
                    password = stateAuth.value.password,
                    password2 = stateAuth.value.password2,
                    number = stateAuth.value.number,
                    screen = stateAuth.value.screen,
                    exception = stateAuth.value.exception
                )
            )
        }
    }

    private fun changePassword(event: ChangePasswordEvent) {
        viewModelScope.launch {
            stateAuth.emit(
                AuthState(
                    isLoading = stateAuth.value.isLoading,
                    login = stateAuth.value.login,
                    password = event.password,
                    password2 = stateAuth.value.password2,
                    number = stateAuth.value.number,
                    screen = stateAuth.value.screen,
                    exception = stateAuth.value.exception
                )
            )
        }
    }

    private fun changePassword2(event: ChangePassword2Event) {
        viewModelScope.launch {
            stateAuth.emit(
                AuthState(
                    isLoading = stateAuth.value.isLoading,
                    login = stateAuth.value.login,
                    password = stateAuth.value.password,
                    password2 = event.password2,
                    number = stateAuth.value.number,
                    screen = stateAuth.value.screen,
                    exception = stateAuth.value.exception
                )
            )
        }
    }

    private fun changeNumber(event: ChangeNumberEvent) {
        viewModelScope.launch {
            stateAuth.emit(
                AuthState(
                    isLoading = stateAuth.value.isLoading,
                    login = stateAuth.value.login,
                    password = stateAuth.value.password,
                    password2 = stateAuth.value.password2,
                    number = event.number,
                    screen = stateAuth.value.screen,
                    exception = stateAuth.value.exception
                )
            )
        }
    }

    private fun checkNumber() {

        viewModelScope.launch {
            stateAuth.emit(
                AuthState(
                    isLoading = true,
                    login = stateAuth.value.login,
                    password = stateAuth.value.password,
                    password2 = stateAuth.value.password2,
                    number = stateAuth.value.number,
                    screen = stateAuth.value.screen,
                    exception = stateAuth.value.exception
                )
            )
            val numberModel = NumberModel(number = stateAuth.value.number)
            authRemoteDataSource.checkNumber(numberModel).let {
                stateAuth.emit(
                    if (it) AuthState(
                        isLoading = false,
                        login = stateAuth.value.login,
                        password = stateAuth.value.password,
                        password2 = stateAuth.value.password2,
                        number = stateAuth.value.number,
                        screen = "login",
                        exception = stateAuth.value.exception
                    ) else AuthState(
                        isLoading = false,
                        login = stateAuth.value.login,
                        password = stateAuth.value.password,
                        password2 = stateAuth.value.password2,
                        number = stateAuth.value.number,
                        screen = "register",
                        exception = stateAuth.value.exception
                    )
                )
            }
        }

    }

    private fun login(context: Context, navController: NavController) {
        try {
            viewModelScope.launch {
                stateAuth.emit(
                    AuthState(
                        isLoading = true,
                        login = stateAuth.value.login,
                        password = stateAuth.value.password,
                        password2 = stateAuth.value.password2,
                        number = stateAuth.value.number,
                        screen = stateAuth.value.screen,
                        exception = stateAuth.value.exception
                    )
                )

                authRemoteDataSource.login(
                    AuthModel(
                        id_role = 1,
                        number = stateAuth.value.number,
                        password = stateAuth.value.password
                    )
                ).let {
                    val dataStoreManager = DataStoreManager(context)
                    Log.d("11", it.toString())
//                    userRepositoryImpl.insertUser(
//                        UserModel(
//                            id_role = it.role,
//                            id_person = it.id_person,
//                            login = it.login
//                        )
//                    )
//                    dataStoreManager.saveUser(
//                        UserDataStoreModel(
//                            refreshToken = it.refresh_token,
//                            accessToken = it.access_token,
//                            number = it.number
//                        )
//                    ).let {
//                        withContext(Dispatchers.Main) {
//                            navController.navigate(Screens.Catalog.route)
//                        }
//                    }
                }

            }
        } catch (e: Exception) {
            Log.d("11", e.message.toString())
        }
    }

    private fun register(context: Context, navController: NavController) {
        viewModelScope.launch {
            try {
                stateAuth.emit(
                    AuthState(
                        isLoading = true,
                        login = stateAuth.value.login,
                        password = stateAuth.value.password,
                        password2 = stateAuth.value.password2,
                        number = stateAuth.value.number,
                        screen = stateAuth.value.screen,
                        exception = stateAuth.value.exception
                    )
                )
                if (stateAuth.value.password == stateAuth.value.password2) {
                    authRemoteDataSource.register(
                        RegModel(
                            id_role = 1,
                            number = stateAuth.value.number,
                            password = stateAuth.value.password,
                            login = stateAuth.value.login
                        )
                    ).let {
                        val dataStoreManager = DataStoreManager(context)
                        userRepositoryImpl.insertUser(
                            UserModel(
                                id_role = it.role,
                                id_person = it.id_person,
                                login = it.login
                            )
                        )
                        dataStoreManager.saveUser(
                            UserDataStoreModel(
                                refreshToken = it.refresh_token,
                                accessToken = it.access_token,
                                number = it.number
                            )
                        ).let {
                            withContext(Dispatchers.Main) {
                                navController.navigate(Screens.Catalog.route)
                            }
                        }
                    }
                } else {
                    stateAuth.emit(
                        AuthState(
                            isLoading = false,
                            login = stateAuth.value.login,
                            password = stateAuth.value.password,
                            password2 = stateAuth.value.password2,
                            number = stateAuth.value.number,
                            screen = stateAuth.value.screen,
                            exception = "Пароли не совпадают"
                        )
                    )
                }
            } catch (e: Exception) {
                Log.d("11", e.message.toString())
            }
        }
    }


}