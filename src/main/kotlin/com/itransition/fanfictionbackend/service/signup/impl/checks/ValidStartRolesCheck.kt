package com.itransition.fanfictionbackend.service.signup.impl.checks

import com.itransition.fanfictionbackend.dto.signup.SignUpRequest
import com.itransition.fanfictionbackend.repository.RoleRepository
import org.springframework.stereotype.Component

@Component
class ValidStartRolesCheck(
    private val roleRepository: RoleRepository
) : SignUpRequestCheck {

    override fun check(signUpRequest: SignUpRequest) {
        val defaultRoleNames = roleRepository.findBySignUpRoleIsTrue().map { it.name }
        if (signUpRequest.roles.all { defaultRoleNames.contains(it) }) {
            throw UnsupportedOperationException()
        }
    }
}
