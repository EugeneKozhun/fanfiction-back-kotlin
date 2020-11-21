package com.itransition.fanfictionbackend.mapper

interface ToWayMapper<E, D> : OneWayMapper<E, D> {

    fun mapInvert(entity: D): E

    fun mapInvert(entity: List<D>): List<E>
}
