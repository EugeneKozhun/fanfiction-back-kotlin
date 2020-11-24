package com.itransition.fanfictionbackend.dto.fanfic

import com.itransition.fanfictionbackend.dto.Dto
import com.itransition.fanfictionbackend.dto.fanfic.chapter.FanficChapterEditDto

data class FanficEditDto(
    var id: Long,
    var title: String,
    var description: String,
    var chapters: List<FanficChapterEditDto> = emptyList()
) : Dto
