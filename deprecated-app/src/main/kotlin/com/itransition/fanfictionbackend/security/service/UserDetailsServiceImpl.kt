package com.itransition.fanfictionbackend.security.service

import com.itransition.fanfictionbackend.repository.UserRepository
import com.itransition.fanfictionbackend.security.model.UserDetailsImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserDetailsServiceImpl(
    private val userRepository: UserRepository
) : UserDetailsService {

    @Transactional(readOnly = true)
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByUsername(username)
            .map { UserDetailsImpl.build(it) }
            .orElseThrow { UsernameNotFoundException("User Not Found with username: $username") }
    }
}
