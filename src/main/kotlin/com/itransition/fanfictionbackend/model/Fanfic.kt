package com.itransition.fanfictionbackend.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity
class Fanfic : BaseEntity() {

    var title: String? = null
    var description: String? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id")
    var author: User? = null

    @OneToMany(mappedBy = "fanfic", orphanRemoval = true)
    val chapters: List<FanficChapter>? = null
}
