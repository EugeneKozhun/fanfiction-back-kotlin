package com.itransition.fanfictionbackend.dto.user

import com.itransition.fanfictionbackend.dto.Dto

data class UserPreviewDto(
    val id: Long,
    val username: String
) : Dto
