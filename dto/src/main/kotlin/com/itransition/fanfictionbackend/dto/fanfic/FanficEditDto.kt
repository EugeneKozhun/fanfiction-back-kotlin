package com.itransition.fanfictionbackend.dto.fanfic

import com.itransition.fanfictionbackend.dto.Dto
import com.itransition.fanfictionbackend.dto.fanfic.chapter.FanficChapterEditDto

data class FanficEditDto(
    val id: Long? = null,
    val title: String,
    val description: String,
    val chapters: List<FanficChapterEditDto> = emptyList()
) : Dto
