package com.itransition.fanfictionbackend.service.auth

import com.itransition.fanfictionbackend.dto.login.LoginRequest
import com.itransition.fanfictionbackend.dto.login.LoginResponse

interface SignInService {

    fun signIn(loginRequest: LoginRequest) : LoginResponse
}
