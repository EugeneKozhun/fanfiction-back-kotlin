package com.itransition.fanfictionbackend.security.jwt

import org.springframework.stereotype.Service
import org.springframework.util.StringUtils.hasText
import java.util.Optional.ofNullable
import javax.servlet.http.HttpServletRequest

/**
 * Проверка Access token.
 */
@Service
internal class JwtValidAccessTokenService : JwtValidService {

    override fun parseJwt(request: HttpServletRequest): String? {
        return ofNullable(request.getHeader(HEADER))
            .filter { hasText(it) }
            .filter { it.startsWith(TOKEN_PREFIX) }
            .map { it.substring(TOKEN_PREFIX.length) }
            .orElse(null)
    }

    companion object {

        const val TOKEN_PREFIX = "Bearer "
        const val HEADER = "Authorization"
    }
}
