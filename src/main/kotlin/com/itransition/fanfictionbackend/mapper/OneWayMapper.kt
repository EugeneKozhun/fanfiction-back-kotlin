package com.itransition.fanfictionbackend.mapper

interface OneWayMapper<E, D> {

    fun toDto(entity: E): D

    fun toDto(entity: List<E>): List<D>
}
