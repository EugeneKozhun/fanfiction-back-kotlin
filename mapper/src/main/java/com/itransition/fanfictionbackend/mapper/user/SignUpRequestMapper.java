package com.itransition.fanfictionbackend.mapper.user;

import com.itransition.fanfictionbackend.dto.signup.SignUpRequest;
import com.itransition.fanfictionbackend.mapper.OneWayMapper;
import com.itransition.fanfictionbackend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SignUpRequestMapper extends OneWayMapper<SignUpRequest, User> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "banned", ignore = true)
    @Mapping(target = "ratings", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "reactions", ignore = true)
    @Mapping(target = "confirmed", ignore = true)
    @Mapping(target = "userFanfics", ignore = true)
    User map(SignUpRequest from);
}
