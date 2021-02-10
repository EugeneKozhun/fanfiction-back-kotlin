package com.itransition.fanfictionbackend.security.jwt.generate

import com.itransition.fanfictionbackend.dto.jwt.JwtTokenContainer
import com.itransition.fanfictionbackend.security.JwtHelper
import com.itransition.fanfictionbackend.security.model.UserDetailsImpl
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthGenerateService(
    private val jwtHelper: JwtHelper
) : JwtGenerateService<Authentication> {

    private fun getUsername(authentication: Authentication): String {
        return Optional.of(authentication)
            .map { obj: Authentication -> obj.principal }
            .map { UserDetailsImpl::class.java.cast(it) }
            .map(UserDetailsImpl::getUsername)
            .orElse(null)
    }

    override fun generate(param: Authentication): JwtTokenContainer {
        return JwtTokenContainer(
            jwtHelper.generateRefreshToken(getUsername(param)),
            jwtHelper.generateAccessToken(getUsername(param))
        )
    }
}
