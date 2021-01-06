package com.itransition.fanfictionbackend.controller

import com.itransition.fanfictionbackend.dto.rating.RatingUpdateDto
import com.itransition.fanfictionbackend.service.rating.RatingService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/ratings"])
class RatingController(
    private val ratingService: RatingService
) {

    @PostMapping(path = ["/update"])
    fun getFanficsPage(ratingUpdateDto: RatingUpdateDto) {
        ratingService.updateRating(ratingUpdateDto);
    }
}
