package com.itransition.fanfictionbackend.mapper

import com.itransition.fanfictionbackend.dto.Dto
import com.itransition.fanfictionbackend.model.BaseEntity

interface Mapper<E : BaseEntity, D : Dto> {

    fun toDto(entity: E): D

    fun toEntity(entity: D): E
}
