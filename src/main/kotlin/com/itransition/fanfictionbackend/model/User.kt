package com.itransition.fanfictionbackend.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "user")
class User : BaseEntity() {

    var username: String? = null
    var password: String? = null

    @ManyToMany
    @JoinTable(
        name = "user_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: Set<Role>? = emptySet()

    @OneToMany(mappedBy = "author", orphanRemoval = true)
    var userFanfics: Set<Fanfic>? = emptySet()
}
