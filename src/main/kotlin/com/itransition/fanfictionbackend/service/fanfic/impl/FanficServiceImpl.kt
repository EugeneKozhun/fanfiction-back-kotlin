package com.itransition.fanfictionbackend.service.fanfic.impl

import com.itransition.fanfictionbackend.dto.common.PageWrapper
import com.itransition.fanfictionbackend.dto.fanfic.FanficEditDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficFullDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficPreviewDto
import com.itransition.fanfictionbackend.mapper.fanfic.toFanficEditDto
import com.itransition.fanfictionbackend.mapper.fanfic.toFanficFullDto
import com.itransition.fanfictionbackend.mapper.fanfic.toFanficPreviewDto
import com.itransition.fanfictionbackend.mapper.fanfic.update
import com.itransition.fanfictionbackend.repository.FanficRepository
import com.itransition.fanfictionbackend.service.fanfic.FanficService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FanficServiceImpl(
    private val fanficRepository: FanficRepository
) : FanficService {

    @Transactional(readOnly = true)
    override fun getPreviewPage(pageable: Pageable): PageWrapper<FanficPreviewDto> {
        val fanficsPage = fanficRepository.findAll(pageable)
        return PageWrapper(
            fanficsPage.totalElements,
            fanficsPage.content.map { it.toFanficPreviewDto() }
        )
    }

    @Transactional(readOnly = true)
    override fun get(id: Long): FanficFullDto {
        return fanficRepository.findById(id)
            .map { it.toFanficFullDto() }
            // TODO: other exception
            .orElseThrow()
    }

    @Transactional(readOnly = true)
    override fun getEdit(id: Long): FanficEditDto {
        return fanficRepository.findById(id)
            .map { it.toFanficEditDto() }
            // TODO: other exception
            .orElseThrow()
    }

    @Transactional
    override fun update(updatedFanfic: FanficEditDto): FanficFullDto {
        val fanfic = fanficRepository.findById(updatedFanfic.id!!).orElseThrow()
        fanfic.update(updatedFanfic)
        return fanfic.toFanficFullDto()
    }

    @Transactional
    override fun delete(fanficId: Long) {
        fanficRepository.deleteById(fanficId)
    }
}
