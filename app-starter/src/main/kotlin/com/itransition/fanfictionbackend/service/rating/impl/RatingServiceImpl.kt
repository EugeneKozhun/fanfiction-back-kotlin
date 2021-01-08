package com.itransition.fanfictionbackend.service.rating.impl

import com.itransition.fanfictionbackend.dto.rating.RatingUpdateDto
import com.itransition.fanfictionbackend.model.Rating
import com.itransition.fanfictionbackend.repository.FanficRepository
import com.itransition.fanfictionbackend.repository.RatingRepository
import com.itransition.fanfictionbackend.repository.UserRepository
import com.itransition.fanfictionbackend.service.rating.RatingService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RatingServiceImpl(
    private val ratingRepository: RatingRepository,
    private val userRepository: UserRepository,
    private val fanficRepository: FanficRepository
) : RatingService {

    @Transactional
    override fun updateRating(ratingUpdateDto: RatingUpdateDto) {
        // TODO: update current or save new
        Rating().apply {
            value = ratingUpdateDto.value
            fanfic = fanficRepository.findById(ratingUpdateDto.fanficId).orElseThrow()
            user = userRepository.findById(ratingUpdateDto.userId).orElseThrow()
        }.let {
            ratingRepository.save(it)
        }
    }
}
