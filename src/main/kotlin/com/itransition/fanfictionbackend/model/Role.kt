package com.itransition.fanfictionbackend.model

import com.itransition.fanfictionbackend.model.enums.ERole
import javax.persistence.Entity
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated

@Entity
class Role : BaseEntity() {

    @Enumerated(STRING)
    var name: ERole? = null
}
