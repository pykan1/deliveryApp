package com.example.deliveryapp.presentation.screen.auth

interface AuthEvent

class ChangeLoginEvent(val login: String): AuthEvent

class ChangePasswordEvent(val password: String): AuthEvent

class ChangeNumberEvent(val number: String): AuthEvent

class LoginEvent(): AuthEvent

class RegisterEvent(): AuthEvent