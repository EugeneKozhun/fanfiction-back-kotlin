package com.itransition.fanfictionbackend.service.signup.impl

import com.itransition.fanfictionbackend.dto.signup.SignUpRequest
import com.itransition.fanfictionbackend.mapper.user.toNewUser
import com.itransition.fanfictionbackend.repository.RoleRepository
import com.itransition.fanfictionbackend.repository.UserRepository
import com.itransition.fanfictionbackend.service.signup.SignUpService
import com.itransition.fanfictionbackend.service.signup.impl.checks.SignUpRequestCheck
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpServiceImpl(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder,
    private val signUpRequestChecks: List<SignUpRequestCheck>
) : SignUpService {

    @Transactional
    override fun signUp(signUpRequest: SignUpRequest) {
        signUpRequestChecks.forEach { it.check(signUpRequest) }

        // TODO: implement confirmation logic.
        //      send confirm code on email.

        val userRoles = roleRepository.findByNameIn(signUpRequest.roles)
        val encodedPassword = passwordEncoder.encode(signUpRequest.password)
        userRepository.save(
            signUpRequest.toNewUser().apply {
                password = encodedPassword
                roles = userRoles
            }
        )
    }
}
