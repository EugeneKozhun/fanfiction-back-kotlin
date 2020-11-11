package com.itransition.fanfictionbackend.security.jwt

import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import java.util.Optional.of
import javax.servlet.http.HttpServletRequest

/**
 * Проверка Access token.
 */
@Service
internal class JwtValidAccessTokenService : JwtValidService {

    override fun parseJwt(request: HttpServletRequest): String? {
        // TODO: check kotlin feathers
        return of(request.getHeader(HEADER))
            .filter { StringUtils.hasText(it) }
            .filter { it.startsWith(TOKEN_PREFIX) }
            .map { it.substring(TOKEN_PREFIX.length) }
            .orElse(null)
    }

    companion object {

        const val TOKEN_PREFIX = "Bearer "
        const val HEADER = "Authorization"
    }
}
