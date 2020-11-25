package com.itransition.fanfictionbackend.service.auth.impl

import com.itransition.fanfictionbackend.dto.login.LoginRequest
import com.itransition.fanfictionbackend.dto.login.LoginResponse
import com.itransition.fanfictionbackend.mapper.user.toAuthUserDto
import com.itransition.fanfictionbackend.repository.UserRepository
import com.itransition.fanfictionbackend.security.jwt.generate.JwtGenerateService
import com.itransition.fanfictionbackend.security.model.UserDetailsImpl
import com.itransition.fanfictionbackend.service.auth.SignInService
import com.itransition.fanfictionbackend.service.auth.impl.checks.UserValidCheck
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
    private val jwtGenerateService: JwtGenerateService<Authentication>,
    private val userValidChecks: List<UserValidCheck>,
    private val userRepository: UserRepository
) : SignInService {

    @Transactional
    override fun signIn(loginRequest: LoginRequest): LoginResponse {
        val user = userRepository.findByUsername(loginRequest.username)
            .orElseThrow()
        userValidChecks.forEach { it.check(user) }

        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        val userDetails = authentication.principal as UserDetailsImpl

        return LoginResponse(userDetails.toAuthUserDto(), jwtGenerateService.generate(authentication))
    }
}
