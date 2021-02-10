package com.itransition.fanfictionbackend.mapper.fanfic;

import com.itransition.fanfictionbackend.dto.fanfic.FanficPreviewDto;
import com.itransition.fanfictionbackend.mapper.OneWayMapper;
import com.itransition.fanfictionbackend.mapper.user.UserPreviewDtoMapper;
import com.itransition.fanfictionbackend.model.Fanfic;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = UserPreviewDtoMapper.class
)
public interface FanficPreviewDtoMapper extends OneWayMapper<Fanfic, FanficPreviewDto> {}
