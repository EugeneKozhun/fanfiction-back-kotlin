package com.itransition.fanfictionbackend.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "user")
class User : WithLongId() {

    var username: String? = null
    var password: String? = null
    var email: String? = null
    var confirmed: Boolean = false
    var banned: Boolean = false

    @OneToMany(mappedBy = "author", orphanRemoval = true)
    var userFanfics: Set<Fanfic> = emptySet()

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    var ratings: List<Rating> = emptyList()

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    var reactions: List<Reaction> = emptyList()

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    var comments: List<Comment> = emptyList()

    @ManyToMany
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: MutableSet<Role> = mutableSetOf()
}
