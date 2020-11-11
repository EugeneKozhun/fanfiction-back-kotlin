package com.itransition.fanfictionbackend.security.jwt.generate

import com.itransition.fanfictionbackend.dto.jwt.JwtTokenContainer
import com.itransition.fanfictionbackend.security.JwtHelper
import org.springframework.stereotype.Service

@Service
class UserNameGenerateStrategy(
    private val jwtHelper: JwtHelper
) : JwtGenerateStrategy<String> {

    override fun generate(param: String): JwtTokenContainer {
        return JwtTokenContainer(
            jwtHelper.generateRefreshToken(param),
            jwtHelper.generateAccessToken(param)
        )
    }
}
