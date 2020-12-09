package com.itransition.fanfictionbackend.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.Lob
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "comment")
class Comment : WithLongId() {

    @Lob
    var message: String? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    val user: User? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "fanfic_id")
    val fanfic: Fanfic? = null
}
