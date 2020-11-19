package com.itransition.fanfictionbackend.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.Lob
import javax.persistence.ManyToOne

@Entity
class FanficChapter : BaseEntity() {

    var title: String? = null

    @Lob
    var content: String? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "fanfic_id")
    var fanfic: Fanfic? = null
}
