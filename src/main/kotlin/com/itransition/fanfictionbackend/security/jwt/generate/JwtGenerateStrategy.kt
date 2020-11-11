package com.itransition.fanfictionbackend.security.jwt.generate

import com.itransition.fanfictionbackend.dto.jwt.JwtTokenContainer

interface JwtGenerateStrategy<T> {

    fun generate(param: T): JwtTokenContainer
}
