package com.itransition.fanfictionbackend.service.signup.impl

import com.itransition.fanfictionbackend.dto.signup.SignUpRequest
import com.itransition.fanfictionbackend.mapper.user.SignUpRequestMapper
import com.itransition.fanfictionbackend.repository.RoleRepository
import com.itransition.fanfictionbackend.repository.UserRepository
import com.itransition.fanfictionbackend.service.signup.SignUpService
import com.itransition.fanfictionbackend.service.signup.impl.checks.SignUpRequestCheck
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class SignUpServiceImpl(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val signUpRequestMapper: SignUpRequestMapper,
    private val signUpRequestChecks: List<SignUpRequestCheck>
) : SignUpService {

    @Transactional
    override fun signUp(signUpRequest: SignUpRequest) {
        signUpRequestChecks.forEach { it.check(signUpRequest) }

        // TODO: implement confirmation logic.
        //      send confirm code on email.

        // TODO: use bean
        val userRoles = roleRepository.findByNameIn(signUpRequest.roles)
        val encodedPassword = BCryptPasswordEncoder().encode(signUpRequest.password)
        userRepository.save(
            signUpRequestMapper.map(signUpRequest).apply {
                password = encodedPassword
                roles = userRoles
            }
        )
    }
}
