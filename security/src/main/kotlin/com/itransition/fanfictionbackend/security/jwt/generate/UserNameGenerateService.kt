package com.itransition.fanfictionbackend.security.jwt.generate

import com.itransition.fanfictionbackend.dto.jwt.JwtTokenContainer
import com.itransition.fanfictionbackend.security.JwtHelper
import org.springframework.stereotype.Service

@Service
class UserNameGenerateService(
    private val jwtHelper: JwtHelper
) : JwtGenerateService<String> {

    override fun generate(param: String): JwtTokenContainer {
        return JwtTokenContainer(
            jwtHelper.generateRefreshToken(param),
            jwtHelper.generateAccessToken(param)
        )
    }
}
