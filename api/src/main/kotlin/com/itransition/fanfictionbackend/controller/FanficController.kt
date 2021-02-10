package com.itransition.fanfictionbackend.controller

import com.itransition.fanfictionbackend.dto.fanfic.FanficEditDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficFullDto
import com.itransition.fanfictionbackend.dto.fanfic.FanficPreviewDto
import com.itransition.fanfictionbackend.service.fanfic.FanficService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/fanfics"])
class FanficController(
    private val fanficService: FanficService
) {

    @GetMapping
    fun getFanficsPage(pageable: Pageable): Page<FanficPreviewDto> {
        return fanficService.getPreviewPage(pageable)
    }

    @GetMapping(path = ["/{id}"])
    fun getFanfic(@PathVariable id: Long): FanficFullDto {
        return fanficService.get(id)
    }

    @GetMapping(path = ["/edit/{id}"])
    fun getEditFanficDto(@PathVariable id: Long): FanficEditDto {
        return fanficService.getEdit(id)
    }

    @PutMapping(path = ["/update"])
    fun updateFanfic(@RequestBody updatedFanfic: FanficEditDto): FanficFullDto {
        return fanficService.update(updatedFanfic)
    }

    @DeleteMapping(path = ["/delete/{id}"])
    fun deleteFanfic(@PathVariable id: Long) {
        fanficService.delete(id)
    }
}
