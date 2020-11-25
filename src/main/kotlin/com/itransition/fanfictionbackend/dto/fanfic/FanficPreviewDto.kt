package com.itransition.fanfictionbackend.dto.fanfic

import com.itransition.fanfictionbackend.dto.Dto
import com.itransition.fanfictionbackend.dto.user.UserPreviewDto

data class FanficPreviewDto(
    var id: Long,
    var title: String,
    var description: String,
    var author: UserPreviewDto
) : Dto
