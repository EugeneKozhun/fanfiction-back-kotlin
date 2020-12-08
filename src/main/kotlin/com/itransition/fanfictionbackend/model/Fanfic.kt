package com.itransition.fanfictionbackend.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "fanfic")
class Fanfic : WithLongId() {

    var title: String? = null
    var description: String? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id")
    var author: User? = null

    @OneToMany(mappedBy = "fanfic", orphanRemoval = true)
    var chapters: MutableList<FanficChapter> = mutableListOf()

    @OneToMany(mappedBy = "fanfic", orphanRemoval = true)
    var ratings: List<Rating> = listOf()

    @OneToMany(mappedBy = "fanfic", orphanRemoval = true)
    var reactions: List<Reaction> = listOf()

    @OneToMany(mappedBy = "fanfic", orphanRemoval = true)
    var comments: List<Comment> = listOf()
}
