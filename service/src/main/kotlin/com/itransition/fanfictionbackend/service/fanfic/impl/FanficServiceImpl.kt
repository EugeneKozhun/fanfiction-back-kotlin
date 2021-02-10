package com.itransition.fanfictionbackend.service.fanfic.impl

import com.itransition.fanfictionbackend.dto.fanfic.FanficEditDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficFullDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficPreviewDto
import com.itransition.fanfictionbackend.mapper.fanfic.FanficEditDtoMapper
import com.itransition.fanfictionbackend.mapper.fanfic.FanficFullDtoMapper
import com.itransition.fanfictionbackend.mapper.fanfic.FanficPreviewDtoMapper
import com.itransition.fanfictionbackend.mapper.fanfic.FanficUpdater
import com.itransition.fanfictionbackend.repository.FanficRepository
import com.itransition.fanfictionbackend.service.fanfic.FanficService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class FanficServiceImpl(
    private val fanficRepository: FanficRepository,
    private val fanficPreviewDtoMapper: FanficPreviewDtoMapper,
    private val fanficFullDtoMapper: FanficFullDtoMapper,
    private val fanficEditDtoMapper: FanficEditDtoMapper,
    private val fanficUpdater: FanficUpdater,
) : FanficService {

    @Transactional(readOnly = true)
    override fun getPreviewPage(pageable: Pageable): Page<FanficPreviewDto> {
        return fanficRepository.findAll(pageable)
            .map { fanficPreviewDtoMapper.map(it) }
    }

    @Transactional(readOnly = true)
    override fun get(id: Long): FanficFullDto {
        return fanficRepository.findById(id)
            .map { fanficFullDtoMapper.map(it) }
            // TODO: other exception
            .orElseThrow()
    }

    @Transactional(readOnly = true)
    override fun getEdit(id: Long): FanficEditDto {
        return fanficRepository.findById(id)
            .map { fanficEditDtoMapper.map(it) }
            // TODO: other exception
            .orElseThrow()
    }

    @Transactional
    override fun update(updatedFanfic: FanficEditDto): FanficFullDto {
        val fanfic = fanficRepository.findById(updatedFanfic.id!!)
            // TODO: other exception
            .orElseThrow()
        fanficUpdater.update(updatedFanfic, fanfic)
        // TODO: check is needed?
        fanficRepository.save(fanfic)
        return fanficFullDtoMapper.map(fanfic)
    }

    @Transactional
    override fun delete(fanficId: Long) {
        fanficRepository.deleteById(fanficId)
    }
}
