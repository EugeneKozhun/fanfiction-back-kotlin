package com.itransition.fanfictionbackend.service.fanfic

import com.itransition.fanfictionbackend.dto.common.PageWrapper
import com.itransition.fanfictionbackend.dto.fanfic.FanficFullDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficPreviewDto
import org.springframework.data.domain.Pageable

interface FanficService {

    fun getPreviewPage(pageable: Pageable): PageWrapper<FanficPreviewDto>

    fun getFanfic(id: Long): FanficFullDto
}
