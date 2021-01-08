package com.itransition.fanfictionbackend.dto.rating

import com.itransition.fanfictionbackend.dto.Dto

data class RatingUpdateDto(
    val userId: Long,
    val fanficId: Long,
    val value: Float
) : Dto
