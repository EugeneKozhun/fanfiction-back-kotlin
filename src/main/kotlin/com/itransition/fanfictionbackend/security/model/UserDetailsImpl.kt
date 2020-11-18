package com.itransition.fanfictionbackend.security.model

import com.itransition.fanfictionbackend.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(
    val id: Long,
    private val username: String,
    private val password: String,
    private val authorities: List<GrantedAuthority>
) : UserDetails {

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

    override fun getAuthorities(): List<GrantedAuthority> {
        return authorities
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    companion object {

        fun build(user: User): UserDetailsImpl {
            return UserDetailsImpl(
                user.id!!,
                user.username!!,
                user.password!!,
                user.roles?.map { SimpleGrantedAuthority(it.name?.name) }!!
            )
        }
    }
}
