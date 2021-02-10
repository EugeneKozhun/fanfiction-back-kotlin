package com.itransition.fanfictionbackend.mapper.fanfic;

import com.itransition.fanfictionbackend.dto.fanfic.FanficEditDto;
import com.itransition.fanfictionbackend.mapper.OneWayUpdater;
import com.itransition.fanfictionbackend.mapper.fanfic.chapter.FanficChapterUpdater;
import com.itransition.fanfictionbackend.model.Fanfic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = "spring",
    uses = FanficChapterUpdater.class
)
public interface FanficUpdater extends OneWayUpdater<Fanfic, FanficEditDto> {

    @Override
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "reactions", ignore = true)
    @Mapping(target = "ratings", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "author", ignore = true)
    void update(FanficEditDto update, @MappingTarget Fanfic target);
}
