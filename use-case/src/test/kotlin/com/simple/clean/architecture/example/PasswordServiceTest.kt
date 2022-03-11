package com.simple.clean.architecture.example

import com.simple.clean.architecture.example.model.PasswordRequest
import com.simple.clean.architecture.example.model.PasswordResponse
import com.simple.clean.architecture.example.service.impl.PasswordServiceImpl
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PasswordServiceTest : FunSpec() {

    private val passwordService = PasswordServiceImpl()

    init {
        test("Tests...") {
            passwordService.isValid(createRequest("")) shouldBe FALSE
            passwordService.isValid(createRequest("aa")) shouldBe FALSE
            passwordService.isValid(createRequest("ab")) shouldBe FALSE
            passwordService.isValid(createRequest("AAAbbbCc")) shouldBe FALSE
            passwordService.isValid(createRequest("AbTp9!foo")) shouldBe FALSE
            passwordService.isValid(createRequest("AbTp9!foA")) shouldBe FALSE
            passwordService.isValid(createRequest("AbTp9 fok")) shouldBe FALSE
            passwordService.isValid(createRequest("AbTp9!fok")) shouldBe TRUE
        }

        test("Some tests...") {
            passwordService.isValid(createRequest("1234567890")) shouldBe FALSE
            passwordService.isValid(createRequest("ABbvq2131!$1234")) shouldBe FALSE
            passwordService.isValid(createRequest("ABbvq75894621!@#$")) shouldBe TRUE
            passwordService.isValid(createRequest("ABbvq75894 621! @#$")) shouldBe FALSE
            passwordService.isValid(createRequest("ABbvq12354!@#$")) shouldBe TRUE
        }
    }

    private fun createRequest(pass: String) = PasswordRequest(pass)

    companion object {
        val TRUE = PasswordResponse(true)
        val FALSE = PasswordResponse(false)
    }
}