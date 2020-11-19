package com.itransition.fanfictionbackend.mapper

import com.itransition.fanfictionbackend.dto.Dto
import com.itransition.fanfictionbackend.model.BaseEntity

interface ToDtoMapper<E : BaseEntity, D : Dto> {

    fun toDto(entity: E): D

    fun toDto(entity: List<E>): List<D>
}
