package com.itransition.fanfictionbackend.mapper.fanfic;

import com.itransition.fanfictionbackend.dto.fanfic.FanficFullDto;
import com.itransition.fanfictionbackend.mapper.OneWayMapper;
import com.itransition.fanfictionbackend.mapper.fanfic.chapter.FanficChapterFullDtoMapper;
import com.itransition.fanfictionbackend.mapper.user.UserPreviewDtoMapper;
import com.itransition.fanfictionbackend.model.Fanfic;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {
        UserPreviewDtoMapper.class,
        FanficChapterFullDtoMapper.class
    }
)
public interface FanficFullDtoMapper extends OneWayMapper<Fanfic, FanficFullDto> {}
