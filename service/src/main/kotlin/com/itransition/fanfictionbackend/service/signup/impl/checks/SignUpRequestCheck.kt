package com.itransition.fanfictionbackend.service.signup.impl.checks

import com.itransition.fanfictionbackend.dto.signup.SignUpRequest

interface SignUpRequestCheck {

    fun check(signUpRequest: SignUpRequest)
}
