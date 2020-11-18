package com.itransition.fanfictionbackend.dto.login

import com.itransition.fanfictionbackend.dto.jwt.JwtTokenContainer
import com.itransition.fanfictionbackend.dto.user.AuthUserDto

data class LoginResponse(
    val user: AuthUserDto,
    val tokens: JwtTokenContainer
)
