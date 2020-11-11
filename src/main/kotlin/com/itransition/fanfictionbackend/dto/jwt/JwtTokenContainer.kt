package com.itransition.fanfictionbackend.dto.jwt

import com.itransition.fanfictionbackend.dto.Dto

data class JwtTokenContainer(
    private val refreshToken: String,
    private val accessToken: String
) : Dto
