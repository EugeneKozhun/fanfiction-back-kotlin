package com.itransition.fanfictionbackend.mapper

import com.itransition.fanfictionbackend.dto.Dto
import com.itransition.fanfictionbackend.model.BaseEntity

interface Mapper<E : BaseEntity, D : Dto> : ToDtoMapper<E, D> {

    fun toEntity(entity: D): E

    fun toEntity(entity: List<D>): List<E>
}
