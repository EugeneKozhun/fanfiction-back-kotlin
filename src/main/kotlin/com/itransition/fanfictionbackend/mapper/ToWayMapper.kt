package com.itransition.fanfictionbackend.mapper

interface ToWayMapper<E, D> : OneWayMapper<E, D> {

    fun toEntity(entity: D): E

    fun toEntity(entity: List<D>): List<E>
}
