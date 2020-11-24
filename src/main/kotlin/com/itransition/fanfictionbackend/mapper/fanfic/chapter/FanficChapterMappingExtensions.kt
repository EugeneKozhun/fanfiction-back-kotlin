package com.itransition.fanfictionbackend.mapper.fanfic.chapter

import com.itransition.fanfictionbackend.dto.fanfic.chapter.FanficChapterEditDto
import com.itransition.fanfictionbackend.dto.fanfic.chapter.FanficChapterFullDto
import com.itransition.fanfictionbackend.model.FanficChapter

fun FanficChapter.toFanficChapterFullDto() = FanficChapterFullDto(
    id = id!!,
    title = title!!,
    content = content!!
)

fun FanficChapter.toFanficChapterEditDto() = FanficChapterEditDto(
    id = id!!,
    title = title!!,
    content = content!!
)

fun FanficChapter.update(patch: FanficChapterEditDto) {
    id = patch.id
    title = patch.title
    content = patch.content
}

fun List<FanficChapter>.update(patch: List<FanficChapterEditDto>) {

}
