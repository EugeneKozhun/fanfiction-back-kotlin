package com.itransition.fanfictionbackend.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
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
    var ratings: List<Rating> = emptyList()

    @OneToMany(mappedBy = "fanfic", orphanRemoval = true)
    var reactions: List<Reaction> = emptyList()

    @OneToMany(mappedBy = "fanfic", orphanRemoval = true)
    var comments: List<Comment> = emptyList()

    @ManyToMany
    @JoinTable(
        name = "fanfic_tag",
        joinColumns = [JoinColumn(name = "fanfic_id")],
        inverseJoinColumns = [JoinColumn(name = "tag_id")]
    )
    var tags: List<Tag> = emptyList()
}
