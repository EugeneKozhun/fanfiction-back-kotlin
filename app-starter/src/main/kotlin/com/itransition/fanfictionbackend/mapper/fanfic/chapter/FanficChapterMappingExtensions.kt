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

fun FanficChapterEditDto.toFanficChapter(): FanficChapter {
    val fanficChapter = FanficChapter()
    fanficChapter.id = id
    fanficChapter.title = title
    fanficChapter.content = content
    return fanficChapter
}

fun FanficChapter.update(patch: FanficChapterEditDto) {
    id = patch.id
    title = patch.title
    content = patch.content
}

fun MutableList<FanficChapter>.update(patch: List<FanficChapterEditDto>) {
    val (toRemove, toUpdate) = this
        .map { it to patch.find { fanficChapterEditDto -> fanficChapterEditDto.id == it.id } }
        .partition { pair -> pair.second == null }
    removeAll(toRemove.map { it.first })
    toUpdate.forEach { it.first.update(it.second!!) }
    val newFanfics = patch.filter { it.id == null }
        .map { it.toFanficChapter() }
    addAll(newFanfics)
}
