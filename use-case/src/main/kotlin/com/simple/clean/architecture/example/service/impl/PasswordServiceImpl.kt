package com.simple.clean.architecture.example.service.impl

import com.simple.clean.architecture.example.model.PasswordRequest
import com.simple.clean.architecture.example.model.PasswordResponse
import com.simple.clean.architecture.example.service.PasswordService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PasswordServiceImpl : PasswordService {

    override fun isValid(request: PasswordRequest): PasswordResponse {
        log.info("Checking password with regex")

        return PasswordResponse(
            valid = REGEX.containsMatchIn(request.password)
        )
    }

    companion object {
        /**
         * Original regex (?!.*(.).*\1)^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*()\-+]){9,}.*$
         */
        private val REGEX = Regex("(?!.*(.).*\\1)^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#\$%^&*()\\-+]){9,}.*\$")
        private val log = LoggerFactory.getLogger(PasswordServiceImpl::class.java)
    }
}
