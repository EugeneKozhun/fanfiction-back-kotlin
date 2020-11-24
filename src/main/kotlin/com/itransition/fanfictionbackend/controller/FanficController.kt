package com.itransition.fanfictionbackend.controller

import com.itransition.fanfictionbackend.dto.common.PageWrapper
import com.itransition.fanfictionbackend.dto.fanfic.FanficEditDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficFullDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficPreviewDto
import com.itransition.fanfictionbackend.service.fanfic.FanficService
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/fanfics"])
class FanficController(
    private val fanficService: FanficService
) {

    @GetMapping
    fun getFanficsPage(pageable: Pageable): PageWrapper<FanficPreviewDto> {
        return fanficService.getPreviewPage(pageable)
    }

    @GetMapping(path = ["/{id}"])
    fun getFanfic(@PathVariable id: Long): FanficFullDto {
        return fanficService.getFanfic(id)
    }

    @GetMapping(path = ["/edit/{id}"])
    fun getEditFanficDto(@PathVariable id: Long): FanficEditDto {
        return fanficService.getEditFanfic(id)
    }

    @PutMapping(path = ["/update"])
    fun updateFanfic(@RequestBody updatedFanfic: FanficEditDto): FanficFullDto {
        return fanficService.updateFanfic(updatedFanfic)
    }

    @DeleteMapping(path = ["/delete/{id}"])
    fun deleteFanfic(@PathVariable id: Long) {
        // TODO: implement
    }
}
