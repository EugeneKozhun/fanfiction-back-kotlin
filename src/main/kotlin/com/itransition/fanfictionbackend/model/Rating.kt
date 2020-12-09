package com.itransition.fanfictionbackend.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "rating")
class Rating : WithLongId() {

    var value: Byte? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    val user: User? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "fanfic_id")
    val fanfic: Fanfic? = null
}
