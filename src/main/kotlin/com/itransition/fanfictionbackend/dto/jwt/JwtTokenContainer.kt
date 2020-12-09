package com.itransition.fanfictionbackend.dto.jwt

import com.itransition.fanfictionbackend.dto.Dto

data class JwtTokenContainer(
    val refreshToken: String,
    val accessToken: String
) : Dto
