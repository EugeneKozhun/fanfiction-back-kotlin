package com.itransition.fanfictionbackend.service.auth.impl

import com.itransition.fanfictionbackend.dto.login.LoginRequest
import com.itransition.fanfictionbackend.dto.login.LoginResponse
import com.itransition.fanfictionbackend.dto.user.AuthUserDto
import com.itransition.fanfictionbackend.security.jwt.generate.JwtGenerateService
import com.itransition.fanfictionbackend.security.model.UserDetailsImpl
import com.itransition.fanfictionbackend.service.auth.SignInService
import org.springframework.context.annotation.Profile
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Profile("dev", "prod")
class SignInServiceImpl(
    private val authenticationManager: AuthenticationManager,
    private val jwtGenerateService: JwtGenerateService<Authentication>
) : SignInService {

    @Transactional
    override fun signIn(loginRequest: LoginRequest): LoginResponse {

        // TODO: add checks chain.
        //      1) Confirmed
        //      2) Banned

        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        val userDetails = authentication.principal as UserDetailsImpl

        return LoginResponse(
            AuthUserDto(userDetails.id, userDetails.username, userDetails.authorities.map { it.authority }),
            jwtGenerateService.generate(authentication)
        )
    }
}
