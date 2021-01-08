package com.itransition.fanfictionbackend.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.Jwts.builder
import io.jsonwebtoken.SignatureAlgorithm.HS512
import org.apache.logging.log4j.LogManager.getLogger
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtHelper {

    @Value("\${app.jwtSecret}")
    private lateinit var jwtSecret: String

    @Value("\${app.jwtAccessTokenExpirationMs}")
    private var jwtAccessTokenExpirationMs = 0

    @Value("\${app.jwtRefreshTokenExpirationMs}")
    private var jwtRefreshTokenExpirationMs = 0

    fun generateAccessToken(userName: String): String {
        return generateDefaultToken(userName, jwtAccessTokenExpirationMs)
    }

    fun generateRefreshToken(userName: String): String {
        return generateDefaultToken(userName, jwtRefreshTokenExpirationMs)
    }

    fun getUserNameFromToken(authToken: String): String {
        return getClaimsJws(authToken)?.body?.subject!!
    }

    fun isValidToken(authToken: String): Boolean {
        try {
            getClaimsJws(authToken)
            return true
        } catch (e: Exception) {
            logger.error("Invalid the JWT token: {}", e.message)
        }
        return false
    }

    private fun generateDefaultToken(userName: String, liveTime: Int): String {
        return builder()
            .setSubject(userName)
            .setIssuedAt(Date())
            .setExpiration(Date(Date().time + liveTime))
            .signWith(HS512, jwtSecret)
            .compact()
    }

    private fun getClaimsJws(authToken: String): Jws<Claims?>? {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken)
    }

    companion object {

        val logger = getLogger(JwtHelper::class.java)!!
    }
}
