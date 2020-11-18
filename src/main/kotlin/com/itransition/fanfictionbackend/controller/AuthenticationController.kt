package com.itransition.fanfictionbackend.controller

import com.itransition.fanfictionbackend.dto.login.LoginRequest
import com.itransition.fanfictionbackend.dto.login.LoginResponse
import com.itransition.fanfictionbackend.service.auth.SignInService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/sign-in"])
class AuthenticationController(
    private val signInService: SignInService
) {

    @PostMapping
    fun singIn(@RequestBody loginRequest: LoginRequest): LoginResponse {
        return signInService.signIn(loginRequest)
    }
}
