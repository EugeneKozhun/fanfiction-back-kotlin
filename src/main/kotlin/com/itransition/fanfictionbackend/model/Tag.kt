package com.itransition.fanfictionbackend.model

import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "tag")
class Tag : WithLongId() {

    val name: String? = null

    @ManyToMany(mappedBy = "tags")
    var fanfics: List<Fanfic> = emptyList()
}
