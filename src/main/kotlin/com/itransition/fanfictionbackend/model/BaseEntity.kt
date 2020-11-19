package com.itransition.fanfictionbackend.model

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity : Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null
}
