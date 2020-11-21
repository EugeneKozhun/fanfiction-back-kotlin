package com.itransition.fanfictionbackend.service.fanfic.impl

import com.itransition.fanfictionbackend.dto.common.PageWrapper
import com.itransition.fanfictionbackend.dto.fanfic.FanficFullDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficPreviewDto
import com.itransition.fanfictionbackend.mapper.fanfic.FanficFullDtoMapper
import com.itransition.fanfictionbackend.mapper.fanfic.FanficPreviewDtoMapper
import com.itransition.fanfictionbackend.repository.FanficRepository
import com.itransition.fanfictionbackend.service.fanfic.FanficService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FanficServiceImpl(
    private val fanficRepository: FanficRepository,
    private val fanficPreviewDtoMapper: FanficPreviewDtoMapper,
    private val fanficFullDtoMapper: FanficFullDtoMapper
) : FanficService {

    @Transactional(readOnly = true)
    override fun getPreviewPage(pageable: Pageable): PageWrapper<FanficPreviewDto> {
        val fanficsPage = fanficRepository.findAll(pageable)
        return PageWrapper(
            fanficsPage.totalElements,
            fanficPreviewDtoMapper.map(fanficsPage.content)
        )
    }

    @Transactional(readOnly = true)
    override fun getFanfic(id: Long): FanficFullDto {
        return fanficRepository.findById(id)
            .map { fanficFullDtoMapper.map(it) }
            // TODO: other exception
            .orElseThrow()
    }
}
