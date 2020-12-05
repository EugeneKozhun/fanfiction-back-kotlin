package com.itransition.fanfictionbackend.service.signup.impl.checks

import com.itransition.fanfictionbackend.dto.signup.SignUpRequest
import com.itransition.fanfictionbackend.repository.UserRepository
import org.springframework.stereotype.Component
import java.lang.UnsupportedOperationException

@Component
class UniqueEmailCheck(
    private val userRepository: UserRepository
) : SignUpRequestCheck {

    override fun check(signUpRequest: SignUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.email)) {
            throw UnsupportedOperationException()
        }
    }
}
