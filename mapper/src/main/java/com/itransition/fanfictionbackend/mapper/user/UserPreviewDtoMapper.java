package com.itransition.fanfictionbackend.mapper.user;

import com.itransition.fanfictionbackend.dto.user.UserPreviewDto;
import com.itransition.fanfictionbackend.mapper.OneWayMapper;
import com.itransition.fanfictionbackend.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPreviewDtoMapper extends OneWayMapper<User, UserPreviewDto> {}
