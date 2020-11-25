package com.itransition.fanfictionbackend.constants

const val ANY_URL = "/**"
const val CSRF_IGNORE_URL = "/sign-in"
val AUTH_POST_RESPONSE_WHITELIST = listOf(
    CSRF_IGNORE_URL,
    "/auth/update-token"
)
val WHITE_LIST = AUTH_POST_RESPONSE_WHITELIST
