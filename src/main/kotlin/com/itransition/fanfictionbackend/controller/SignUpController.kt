package com.itransition.fanfictionbackend.controller

import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(path = ["/sign-up"])
class SignUpController {

    @PostMapping
    @ResponseStatus(value = CREATED)
    fun registerUser(@RequestBody signUpRequestDto: Any) {
        // TODO: implement
    }

    @PostMapping(path = ["/confirm"])
    fun confirmUser(@RequestBody confirmationId: UUID) {
        // TODO: implement
    }
}
