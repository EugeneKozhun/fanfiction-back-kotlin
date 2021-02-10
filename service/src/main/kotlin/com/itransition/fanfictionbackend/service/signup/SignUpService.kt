package com.itransition.fanfictionbackend.service.signup

import com.itransition.fanfictionbackend.dto.signup.SignUpRequest

interface SignUpService {

    fun signUp(signUpRequest: SignUpRequest)
}
