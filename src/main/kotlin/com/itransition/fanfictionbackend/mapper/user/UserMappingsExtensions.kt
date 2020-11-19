package com.itransition.fanfictionbackend.mapper.user

import com.itransition.fanfictionbackend.dto.user.AuthUserDto
import com.itransition.fanfictionbackend.security.model.UserDetailsImpl

fun UserDetailsImpl.toAuthUserDto() = AuthUserDto(
    id = id,
    username = username,
    roles = authorities.map { it.authority }
)
