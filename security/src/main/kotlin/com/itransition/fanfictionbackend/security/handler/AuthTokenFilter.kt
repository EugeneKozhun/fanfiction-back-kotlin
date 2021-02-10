package com.itransition.fanfictionbackend.security.handler

import com.itransition.fanfictionbackend.common.constants.WHITE_LIST
import com.itransition.fanfictionbackend.security.JwtHelper
import com.itransition.fanfictionbackend.security.jwt.JwtValidService
import org.springframework.context.annotation.Profile
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder.getContext
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Service
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.util.Optional.ofNullable
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Service
@Profile("!stub")
class AuthTokenFilter(
    private val jwtHelper: JwtHelper,
    private val validAccessToken: JwtValidService,
    private val userDetailsServiceImpl: UserDetailsService
) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            ofNullable(validAccessToken.parseJwt(request))
                .filter { jwtHelper.isValidToken(it) }
                .map { jwtHelper.getUserNameFromToken(it) }
                .map { userDetailsServiceImpl.loadUserByUsername(it) }
                .map { UsernamePasswordAuthenticationToken(it, null, it.authorities) }
                .ifPresent {
                    it.details = WebAuthenticationDetailsSource().buildDetails(request)
                    getContext().authentication = it
                }
        } catch (e: Exception) {
            logger.error("Cannot set user authentication: {}", e)
        }
        filterChain.doFilter(request, response)
    }

    override fun shouldNotFilter(request: HttpServletRequest) = WHITE_LIST.any { it == request.requestURI }
}
