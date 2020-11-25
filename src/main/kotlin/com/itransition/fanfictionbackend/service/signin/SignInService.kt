package com.itransition.fanfictionbackend.service.signin

import com.itransition.fanfictionbackend.dto.signin.SignInRequest
import com.itransition.fanfictionbackend.dto.signin.SignInResponse

interface SignInService {

    fun signIn(signInRequest: SignInRequest) : SignInResponse
}
