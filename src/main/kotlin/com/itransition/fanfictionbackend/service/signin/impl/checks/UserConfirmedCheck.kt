package com.itransition.fanfictionbackend.service.signin.impl.checks

import com.itransition.fanfictionbackend.model.User
import org.springframework.stereotype.Component

@Component
class UserConfirmedCheck : UserValidCheck {

    override fun check(user: User) {
        if (!user.confirmed) {
            throw UnsupportedOperationException()
        }
    }
}
