package com.itransition.fanfictionbackend.dto.fanfic

import com.itransition.fanfictionbackend.dto.Dto
import com.itransition.fanfictionbackend.dto.user.UserPreviewDto

data class FanficPreviewDto(
    val id: Long,
    val title: String,
    val description: String,
    val author: UserPreviewDto
) : Dto
