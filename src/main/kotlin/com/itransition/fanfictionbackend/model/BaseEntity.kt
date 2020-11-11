package com.itransition.fanfictionbackend.model

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity : Serializable {

    @Id
    @GeneratedValue
    var id: Long? = null
}
