package com.itransition.fanfictionbackend.service.auth.impl.checks

import com.itransition.fanfictionbackend.model.User

interface UserValidCheck {

    fun check(user: User)
}
