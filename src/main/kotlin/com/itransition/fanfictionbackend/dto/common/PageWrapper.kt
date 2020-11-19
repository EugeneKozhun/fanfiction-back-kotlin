package com.itransition.fanfictionbackend.dto.common

import com.itransition.fanfictionbackend.dto.Dto

data class PageWrapper<T>(
    val totalCount: Long,
    val elements: List<T>
) : Dto
