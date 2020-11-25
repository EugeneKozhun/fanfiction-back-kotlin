package com.itransition.fanfictionbackend.config

import com.itransition.fanfictionbackend.constants.ANY_URL
import com.itransition.fanfictionbackend.constants.AUTH_POST_RESPONSE_WHITELIST
import com.itransition.fanfictionbackend.constants.CSRF_IGNORE_URL
import com.itransition.fanfictionbackend.security.handler.AuthEntryPointJwt
import com.itransition.fanfictionbackend.security.handler.AuthTokenFilter
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy.STATELESS
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

sealed class SecurityConfig : WebSecurityConfigurerAdapter()

@Profile("!stub")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class JwtSecurityConfig(
    private val passwordEncoder: PasswordEncoder,
    @Qualifier("userDetailsServiceImpl")
    private val userDetailsService: UserDetailsService,
    private val authEntryPoint: AuthEntryPointJwt,
    private val authenticationJwtTokenFilter: AuthTokenFilter
) : SecurityConfig() {

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager = super.authenticationManagerBean()

    override fun configure(web: WebSecurity) {
        web.ignoring()
            .antMatchers(HttpMethod.POST, *AUTH_POST_RESPONSE_WHITELIST.toTypedArray())
            .antMatchers(HttpMethod.OPTIONS, ANY_URL)
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder)
    }

    @Throws(Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity
            .csrf {
                it.ignoringAntMatchers(*CSRF_IGNORE_URL.toTypedArray())
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            }
            .authorizeRequests {
                it.antMatchers(ANY_URL)
                    .access("isAuthenticated()")
            }
            .exceptionHandling { it.authenticationEntryPoint(authEntryPoint) }
            .addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
            .sessionManagement()
            .sessionCreationPolicy(STATELESS);
    }
}

@Profile("stub")
@Configuration
class NoSecurityConfig : SecurityConfig() {

    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(ANY_URL)
    }
}
