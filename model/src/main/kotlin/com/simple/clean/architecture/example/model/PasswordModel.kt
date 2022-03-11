package com.simple.clean.architecture.example.model

data class PasswordRequest(
    val password: String
)

data class PasswordResponse(
    val valid: Boolean
)