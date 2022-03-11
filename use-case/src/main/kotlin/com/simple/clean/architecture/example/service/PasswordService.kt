package com.simple.clean.architecture.example.service

import com.simple.clean.architecture.example.model.PasswordRequest
import com.simple.clean.architecture.example.model.PasswordResponse

interface PasswordService {

    fun isValid(request: PasswordRequest): PasswordResponse
}