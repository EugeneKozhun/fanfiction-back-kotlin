package com.itransition.fanfictionbackend.service.signin.impl

import com.itransition.fanfictionbackend.dto.signin.SignInRequest
import com.itransition.fanfictionbackend.dto.signin.SignInResponse
import com.itransition.fanfictionbackend.dto.user.AuthUserDto
import com.itransition.fanfictionbackend.repository.UserRepository
import com.itransition.fanfictionbackend.security.jwt.generate.JwtGenerateService
import com.itransition.fanfictionbackend.security.model.UserDetailsImpl
import com.itransition.fanfictionbackend.service.signin.SignInService
import com.itransition.fanfictionbackend.service.signin.impl.checks.UserValidCheck
import org.springframework.context.annotation.Profile
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Profile("test", "dev", "prod")
open class SignInServiceImpl(
    private val authenticationManager: AuthenticationManager,
    private val jwtGenerateService: JwtGenerateService<Authentication>,
    private val userValidChecks: List<UserValidCheck>,
    private val userRepository: UserRepository
) : SignInService {

    @Transactional
    override fun signIn(signInRequest: SignInRequest): SignInResponse {
        val user = userRepository.findByUsername(signInRequest.username)
            .orElseThrow()
        userValidChecks.forEach { it.check(user) }

        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(signInRequest.username, signInRequest.password)
        )
        SecurityContextHolder.getContext().authentication = authentication
        val userDetails = authentication.principal as UserDetailsImpl

        return SignInResponse(userDetails.toAuthUserDto(), jwtGenerateService.generate(authentication))
    }

    private fun UserDetailsImpl.toAuthUserDto() = AuthUserDto(
        id = id,
        username = username,
        roles = authorities.map { it.authority }
    )
}
