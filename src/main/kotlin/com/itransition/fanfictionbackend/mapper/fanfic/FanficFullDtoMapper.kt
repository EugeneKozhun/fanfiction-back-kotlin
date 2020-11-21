package com.itransition.fanfictionbackend.mapper.fanfic

import com.itransition.fanfictionbackend.dto.fanfic.FanficFullDto
import com.itransition.fanfictionbackend.mapper.OneWayMapper
import com.itransition.fanfictionbackend.mapper.fanfic.chapter.FanficChapterFullMapper
import com.itransition.fanfictionbackend.mapper.user.UserPreviewDtoMapper
import com.itransition.fanfictionbackend.model.Fanfic
import org.mapstruct.Mapper

@Mapper(
    componentModel = "spring",
    uses = [
        UserPreviewDtoMapper::class,
        FanficChapterFullMapper::class
    ]
)
interface FanficFullDtoMapper : OneWayMapper<Fanfic, FanficFullDto>
