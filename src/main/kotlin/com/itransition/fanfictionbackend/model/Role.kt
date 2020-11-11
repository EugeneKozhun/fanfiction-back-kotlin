package com.itransition.fanfictionbackend.model

import com.itransition.fanfictionbackend.model.enums.ERole
import javax.persistence.Entity
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated
import javax.persistence.Table

/**
 * Role entity.
 */
@Entity
@Table(name = "role")
class Role : BaseEntity() {

    @Enumerated(STRING)
    var name: ERole? = null
}
