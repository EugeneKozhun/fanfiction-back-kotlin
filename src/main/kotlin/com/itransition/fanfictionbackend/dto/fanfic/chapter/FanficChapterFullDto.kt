package com.itransition.fanfictionbackend.dto.fanfic.chapter

import com.itransition.fanfictionbackend.dto.Dto

data class FanficChapterFullDto(
    val id: Long,
    val title: String,
    val content: String
) : Dto
