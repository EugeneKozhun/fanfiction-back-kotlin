package com.itransition.fanfictionbackend.service.rating

import com.itransition.fanfictionbackend.dto.rating.RatingUpdateDto

interface RatingService {

    fun updateRating(ratingUpdateDto: RatingUpdateDto)
}
