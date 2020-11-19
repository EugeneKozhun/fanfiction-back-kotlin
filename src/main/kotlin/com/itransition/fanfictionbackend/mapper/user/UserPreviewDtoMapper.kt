package com.itransition.fanfictionbackend.mapper.user

import com.itransition.fanfictionbackend.dto.user.UserPreviewDto
import com.itransition.fanfictionbackend.mapper.ToDtoMapper
import com.itransition.fanfictionbackend.model.User
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserPreviewDtoMapper : ToDtoMapper<User, UserPreviewDto>
