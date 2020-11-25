package com.itransition.fanfictionbackend.service.auth.impl

import com.itransition.fanfictionbackend.dto.jwt.JwtTokenContainer
import com.itransition.fanfictionbackend.dto.login.LoginRequest
import com.itransition.fanfictionbackend.dto.login.LoginResponse
import com.itransition.fanfictionbackend.dto.user.AuthUserDto
import com.itransition.fanfictionbackend.service.auth.SignInService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("stub")
internal class SignInServiceStub : SignInService {

    override fun signIn(loginRequest: LoginRequest): LoginResponse {
        return LoginResponse(
            AuthUserDto(STUB_ID, STUB_USERNAME, STUB_ROLES),
            JwtTokenContainer(STUB_TOKEN, STUB_TOKEN)
        )
    }

    companion object {

        private const val STUB_TOKEN = "eyJhbGciOiJIUzUxMiJ9"
        private const val STUB_ID = 1L
        private const val STUB_USERNAME = "stub"
        private val STUB_ROLES = listOf("ROLE_ADMIN")
    }
}
