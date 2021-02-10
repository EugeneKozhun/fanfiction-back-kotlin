package com.itransition.fanfictionbackend.mapper.fanfic;

import com.itransition.fanfictionbackend.dto.fanfic.FanficEditDto;
import com.itransition.fanfictionbackend.mapper.OneWayMapper;
import com.itransition.fanfictionbackend.mapper.fanfic.chapter.FanficChapterEditDtoMapper;
import com.itransition.fanfictionbackend.model.Fanfic;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = FanficChapterEditDtoMapper.class
)
public interface FanficEditDtoMapper extends OneWayMapper<Fanfic, FanficEditDto> {}
