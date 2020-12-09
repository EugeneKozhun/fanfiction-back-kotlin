package com.itransition.fanfictionbackend.constants

const val ANY_URL = "/**"
val CSRF_IGNORE_URL = listOf(
    "/sign-in",
    "/sign-up"
)
val AUTH_POST_RESPONSE_WHITELIST = listOf(
    *CSRF_IGNORE_URL.toTypedArray(),
    "/auth/update-token"
)
val WHITE_LIST = AUTH_POST_RESPONSE_WHITELIST
