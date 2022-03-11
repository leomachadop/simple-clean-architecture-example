package com.simple.clean.architecture.example

import com.simple.clean.architecture.example.api.PasswordApi
import com.simple.clean.architecture.example.model.PasswordRequest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PasswordApiTest(@Autowired val api: PasswordApi) {

    @Test
    fun `Api tests`() {
        Assertions.assertThat(api).isNotNull

        Assertions.assertThat(HttpStatus.PRECONDITION_FAILED)
            .isEqualTo(api.validatePassword(PasswordRequest("APITA")).statusCode)

        Assertions.assertThat(HttpStatus.ACCEPTED)
            .isEqualTo(api.validatePassword(PasswordRequest("ABbvq12354!@#$")).statusCode)

        Assertions.assertThat(HttpStatus.ACCEPTED)
            .isEqualTo(api.validatePassword(PasswordRequest("gvs@&0C1!GFlo")).statusCode)

        Assertions.assertThat(HttpStatus.ACCEPTED)
            .isEqualTo(api.validatePassword(PasswordRequest("MGFhnU8DQ5X&BfC")).statusCode)

        Assertions.assertThat(HttpStatus.PRECONDITION_FAILED)
            .isEqualTo(api.validatePassword(PasswordRequest("gLozEReTHY")).statusCode)

    }
}