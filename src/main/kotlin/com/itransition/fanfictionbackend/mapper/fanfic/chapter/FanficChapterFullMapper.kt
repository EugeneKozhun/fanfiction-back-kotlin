package com.itransition.fanfictionbackend.mapper.fanfic.chapter

import com.itransition.fanfictionbackend.dto.fanfic.chapter.FanficChapterFullDto
import com.itransition.fanfictionbackend.mapper.OneWayMapper
import com.itransition.fanfictionbackend.model.FanficChapter
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface FanficChapterFullMapper : OneWayMapper<FanficChapter, FanficChapterFullDto>
