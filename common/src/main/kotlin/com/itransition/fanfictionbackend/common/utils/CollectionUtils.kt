package com.itransition.fanfictionbackend.common

fun <T, U> MutableList<T>.update(patch: List<U>) {
//    val (toRemove, toUpdate) = this
//        .map { it to patch.find { fanficChapterEditDto -> fanficChapterEditDto.id == it.id } }
//        .partition { pair -> pair.second == null }
//    removeAll(toRemove.map { it.first })
//    toUpdate.forEach { it.first.update(it.second!!) }
//    val newFanfics = patch.filter { it.id == null }
//        .map { it.toFanficChapter() }
//    addAll(newFanfics)
}

