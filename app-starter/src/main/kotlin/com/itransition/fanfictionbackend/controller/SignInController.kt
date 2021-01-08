package com.itransition.fanfictionbackend.controller

import com.itransition.fanfictionbackend.dto.signin.SignInRequest
import com.itransition.fanfictionbackend.dto.signin.SignInResponse
import com.itransition.fanfictionbackend.service.signin.SignInService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/sign-in"])
class SignInController(
    private val signInService: SignInService
) {

    @PostMapping
    fun singIn(@RequestBody signInRequest: SignInRequest): SignInResponse {
        return signInService.signIn(signInRequest)
    }
}
