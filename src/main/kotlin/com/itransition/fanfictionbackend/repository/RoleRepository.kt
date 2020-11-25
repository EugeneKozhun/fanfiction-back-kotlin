package com.itransition.fanfictionbackend.repository

import com.itransition.fanfictionbackend.model.Role
import com.itransition.fanfictionbackend.model.enums.ERole
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository : BaseRepository<Role> {

    fun findByNameIn(role: List<ERole>): MutableSet<Role>
}
