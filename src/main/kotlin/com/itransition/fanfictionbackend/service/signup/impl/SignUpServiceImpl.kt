package com.itransition.fanfictionbackend.service.signup.impl

import com.itransition.fanfictionbackend.dto.signup.SignUpRequest
import com.itransition.fanfictionbackend.mapper.user.toNewUser
import com.itransition.fanfictionbackend.repository.RoleRepository
import com.itransition.fanfictionbackend.repository.UserRepository
import com.itransition.fanfictionbackend.service.signup.SignUpService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpServiceImpl(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder
) : SignUpService {

    @Transactional
    override fun signUp(signUpRequest: SignUpRequest) {
        // TODO: implement:
        //       1) add checks (username, email, roles)
        //       2) email confirmation
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
