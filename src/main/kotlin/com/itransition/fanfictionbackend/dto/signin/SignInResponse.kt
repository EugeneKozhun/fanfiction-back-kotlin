package com.itransition.fanfictionbackend.dto.signin

import com.itransition.fanfictionbackend.dto.jwt.JwtTokenContainer
import com.itransition.fanfictionbackend.dto.user.AuthUserDto

data class SignInResponse(
    val user: AuthUserDto,
    val tokens: JwtTokenContainer
)
