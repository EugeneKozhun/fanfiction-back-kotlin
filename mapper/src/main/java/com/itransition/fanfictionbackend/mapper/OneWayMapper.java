package com.itransition.fanfictionbackend.mapper;

public interface OneWayMapper<F, T> {

    T map(F from);
}
