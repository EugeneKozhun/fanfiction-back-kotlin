package com.itransition.fanfictionbackend.mapper.fanfic

import com.itransition.fanfictionbackend.dto.fanfic.FanficEditDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficFullDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficPreviewDto
import com.itransition.fanfictionbackend.mapper.fanfic.chapter.toFanficChapterEditDto
import com.itransition.fanfictionbackend.mapper.fanfic.chapter.toFanficChapterFullDto
import com.itransition.fanfictionbackend.mapper.fanfic.chapter.update
import com.itransition.fanfictionbackend.mapper.user.toUserPreviewDto
import com.itransition.fanfictionbackend.model.Fanfic

fun Fanfic.toFanficPreviewDto() = FanficPreviewDto(
    id = id!!,
    title = title!!,
    description = description!!,
    author = author!!.toUserPreviewDto()
)

fun Fanfic.toFanficFullDto() = FanficFullDto(
    id = id!!,
    title = title!!,
    description = description!!,
    author = author!!.toUserPreviewDto(),
    chapters = chapters.map { it.toFanficChapterFullDto() }
)

fun Fanfic.toFanficEditDto() = FanficEditDto(
    id = id!!,
    title = title!!,
    description = description!!,
    chapters = chapters.map { it.toFanficChapterEditDto() }
)

fun Fanfic.update(patch: FanficEditDto) {
    id = patch.id
    title = patch.title
    description = patch.description
    chapters.update(patch.chapters)
}
