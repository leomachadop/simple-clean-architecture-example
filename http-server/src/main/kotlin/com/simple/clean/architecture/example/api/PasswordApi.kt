package com.simple.clean.architecture.example.api

import com.simple.clean.architecture.example.model.PasswordRequest
import com.simple.clean.architecture.example.model.PasswordResponse
import com.simple.clean.architecture.example.service.PasswordService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("password")
class PasswordApi(val passwordService: PasswordService) {

    companion object {
        private val log = LoggerFactory.getLogger(PasswordApi::class.java)
    }

    @PostMapping("validate")
    fun validatePassword(@RequestBody password: PasswordRequest): ResponseEntity<PasswordResponse> {

        log.info("Validating request")

        val isValid = passwordService.isValid(password)

        log.info("isValid $isValid")

        return if (isValid.valid) {
            ResponseEntity(
                isValid,
                HttpStatus.ACCEPTED
            )
        } else {
            ResponseEntity(
                isValid,
                HttpStatus.PRECONDITION_FAILED
            )
        }
    }
}