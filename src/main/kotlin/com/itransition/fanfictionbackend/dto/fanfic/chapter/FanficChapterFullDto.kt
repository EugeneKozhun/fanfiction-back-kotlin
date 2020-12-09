package com.itransition.fanfictionbackend.dto.fanfic.chapter

import com.itransition.fanfictionbackend.dto.Dto

data class FanficChapterFullDto(
    var id: Long,
    var title: String,
    var content: String
) : Dto
