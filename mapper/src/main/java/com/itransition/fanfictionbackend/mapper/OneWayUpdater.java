package com.itransition.fanfictionbackend.mapper;

public interface OneWayUpdater<T, U> {

    void update(U update, T target);
}
