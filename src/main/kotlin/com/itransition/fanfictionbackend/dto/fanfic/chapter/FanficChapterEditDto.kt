package com.itransition.fanfictionbackend.dto.fanfic.chapter

data class FanficChapterEditDto(
    val id: Long? = null,
    val title: String,
    val content: String
)
