package com.itransition.fanfictionbackend.model.lookup

import com.itransition.fanfictionbackend.model.Reaction
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "reaction_lut")
class ReactionLookUp {

    @Id
    var name: String? = null

    @OneToMany(mappedBy = "value", orphanRemoval = true)
    var reaction: List<Reaction> = listOf()
}
