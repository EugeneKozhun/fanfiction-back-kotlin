package com.itransition.fanfictionbackend.dto.user

data class AuthUserDto(
    val id: Long,
    val username: String,
    val roles: List<String>
)
