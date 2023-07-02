package com.example.deliveryapp.presentation.navigation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NavigationViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
): ViewModel() {

    val stateNavigation = MutableStateFlow(NavigationState())

    fun send(event: NavigationEvent) {
        when(event) {
            is GetUserEvent -> {
                getUser()
            }
        }
    }

    private fun getUser() {
        viewModelScope.launch {
            getUserUseCase.invoke().let {
                if (it != null) {
                    Log.d("11", "есть")
                } else {
                Log.d("11", "пусто")}
                stateNavigation.emit(NavigationState(
                    isLoading = false,
                    user = it
                ))
            }
        }
    }

}