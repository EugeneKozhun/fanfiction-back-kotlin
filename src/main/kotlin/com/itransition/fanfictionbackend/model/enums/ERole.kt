package com.itransition.fanfictionbackend.model.enums

enum class ERole {
    ADMIN,
    MODERATOR,
    WRITER,
    READER;

    companion object {

        fun getDefaultRoles() = listOf(READER)
    }
}
