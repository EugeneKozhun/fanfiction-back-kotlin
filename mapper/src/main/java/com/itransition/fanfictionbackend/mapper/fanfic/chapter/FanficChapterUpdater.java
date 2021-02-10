package com.itransition.fanfictionbackend.mapper.fanfic.chapter;

import com.itransition.fanfictionbackend.dto.fanfic.chapter.FanficChapterEditDto;
import com.itransition.fanfictionbackend.mapper.OneWayUpdater;
import com.itransition.fanfictionbackend.model.FanficChapter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FanficChapterUpdater extends OneWayUpdater<FanficChapter, FanficChapterEditDto> {

    @Override
    @Mapping(target = "fanfic", ignore = true)
    void update(FanficChapterEditDto update, @MappingTarget FanficChapter target);

    void update(List<FanficChapterEditDto> update, @MappingTarget List<FanficChapter> target);
}
