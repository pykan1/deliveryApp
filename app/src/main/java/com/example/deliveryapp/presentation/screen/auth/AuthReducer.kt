package com.example.deliveryapp.presentation.screen.auth

import android.content.Context
import android.util.Log
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
import com.example.deliveryapp.presentation.screen.base.Reducer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class AuthReducer(
    initial: AuthState,
    val viewModelScope: CoroutineScope,
    val userRepositoryImpl: UserRepositoryImpl,
    val authRemoteDataSource: AuthRemoteDataSource
) : Reducer<AuthState, AuthEvent>(initial) {

    override fun reduce(oldState: AuthState, event: AuthEvent) {

        when (event) {
            is AuthEvent.ChangeLoginEvent -> {
                changeLogin(oldState, event)
            }

            is AuthEvent.ChangePasswordEvent -> {
                changePassword(oldState, event)
            }

            is AuthEvent.ChangePassword2Event -> {
                changePassword2(oldState, event)
            }

            is AuthEvent.ChangeNumberEvent -> {
                changeNumber(oldState, event)
            }

            is AuthEvent.CheckNumberEvent -> {
                checkNumber(oldState)
            }

            is AuthEvent.LoginEvent -> {
                login(oldState, event.context, event.navController)
            }

            is AuthEvent.RegisterEvent -> {
                register(oldState, event.context, event.navController)
            }
        }
    }

    private fun changeLogin(oldState: AuthState, event: AuthEvent.ChangeLoginEvent) {
        viewModelScope.launch {
//            setState(oldState.copy(login = event.login))
        }
    }

    private fun changePassword(oldState: AuthState, event: AuthEvent.ChangePasswordEvent) {
        viewModelScope.launch {
//            setState(oldState.copy(password = event.password))
        }
    }

    private fun changePassword2(oldState: AuthState, event: AuthEvent.ChangePassword2Event) {
        viewModelScope.launch {
//            setState(oldState.copy(password2 = event.password2))
        }
    }

    private fun changeNumber(oldState: AuthState, event: AuthEvent.ChangeNumberEvent) {
        viewModelScope.launch {
//            setState(oldState.copy(number = event.number))
        }
    }

    private fun checkNumber(oldState: AuthState) {

        viewModelScope.launch {
            val numberModel = NumberModel(number = oldState.number.value)
            authRemoteDataSource.checkNumber(numberModel).let {
                setState(
                    if (it) oldState.copy(screen = "login") else oldState.copy(screen = "register")
                )
            }
        }

    }

    private fun login(oldState: AuthState, context: Context, navController: NavController) {
        try {
            viewModelScope.launch {

                authRemoteDataSource.login(
                    AuthModel(
                        id_role = 1,
                        number = oldState.number.value,
                        password = oldState.password.value
                    )
                ).let {
                    Log.d("11", "login user data $it")
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

            }
        } catch (e: Exception) {
            Log.d("11", e.message.toString())
        }
    }

    private fun register(oldState: AuthState, context: Context, navController: NavController) {
        viewModelScope.launch {
            try {
                if (oldState.password == oldState.password2) {
                    authRemoteDataSource.register(
                        RegModel(
                            id_role = 1,
                            number = oldState.number.value,
                            password = oldState.password.value,
                            login = oldState.login.value
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
                    setState(oldState.copy(exception = "Пароли не совпадают"))
                }
            } catch (e: Exception) {
                Log.d("11", e.message.toString())
            }
        }
    }
}