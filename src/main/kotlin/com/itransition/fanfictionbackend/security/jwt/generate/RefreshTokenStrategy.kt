package com.itransition.fanfictionbackend.security.jwt.generate

import com.itransition.fanfictionbackend.dto.jwt.JwtTokenContainer
import com.itransition.fanfictionbackend.security.JwtHelper
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class RefreshTokenStrategy(
    private val jwtHelper: JwtHelper
) : JwtGenerateStrategy<String> {

    override fun generate(param: String): JwtTokenContainer {
        return Optional.of(param)
            .filter { jwtHelper.isValidToken(it) }
            .map { jwtHelper.getUserNameFromToken(it) }
            .map {
                JwtTokenContainer(
                    jwtHelper.generateRefreshToken(it!!),
                    jwtHelper.generateAccessToken(it)
                )
            }
            .orElseThrow()
    }
}
