package com.itransition.fanfictionbackend.security.jwt

import javax.servlet.http.HttpServletRequest

interface JwtValidService {

    fun parseJwt(request: HttpServletRequest): String?
}
