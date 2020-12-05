package com.itransition.fanfictionbackend.model

import com.itransition.fanfictionbackend.model.lookup.ReactionLookUp
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "reaction")
class Reaction : WithLongId() {

    @ManyToOne(optional = false)
    @JoinColumn(name = "reaction_lut_id")
    var value: ReactionLookUp? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    val user: User? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "fanfic_id")
    val fanfic: Fanfic? = null
}
