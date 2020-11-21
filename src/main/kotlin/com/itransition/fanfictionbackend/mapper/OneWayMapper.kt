package com.itransition.fanfictionbackend.mapper

interface OneWayMapper<E, D> {

    fun map(entity: E): D

    fun map(entity: List<E>): List<D>
}
