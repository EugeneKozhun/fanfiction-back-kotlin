package com.itransition.fanfictionbackend.service.signin.impl

import com.itransition.fanfictionbackend.dto.jwt.JwtTokenContainer
import com.itransition.fanfictionbackend.dto.signin.SignInRequest
import com.itransition.fanfictionbackend.dto.signin.SignInResponse
import com.itransition.fanfictionbackend.dto.user.AuthUserDto
import com.itransition.fanfictionbackend.service.signin.SignInService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("stub")
class SignInServiceStub : SignInService {

    override fun signIn(signInRequest: SignInRequest): SignInResponse {
        return SignInResponse(
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
