package com.itransition.fanfictionbackend.repository

import com.itransition.fanfictionbackend.model.User
import java.util.Optional

interface UserRepository : BaseRepository<User> {

    fun findByUsername(username: String): Optional<User>

    fun existsByEmail(email: String): Boolean

    fun existsByUsername(username: String): Boolean
}
