package com.itransition.fanfictionbackend.dto.signup

import com.itransition.fanfictionbackend.dto.Dto
import com.itransition.fanfictionbackend.model.enums.ERole

data class SignUpRequest(
    val username: String,
    val password: String,
    val email: String,
    val roles: List<ERole>
) : Dto
