package com.itransition.fanfictionbackend.model

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "rating")
class Rating : WithLongId() {

    var value: Float? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    var user: User? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "fanfic_id")
    var fanfic: Fanfic? = null
}
