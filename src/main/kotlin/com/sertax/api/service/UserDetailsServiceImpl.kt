package com.sertax.api.service

import com.sertax.api.model.User
import com.sertax.api.repository.UserRepository
import com.sertax.api.user.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository) : UserDetailsService {
	
	override fun loadUserByUsername(email: String): UserDetails {
		val user: User = userRepository.findByEmail(email)
			?: throw UsernameNotFoundException("User not found with email: $email")
		
		val authorities = listOf(SimpleGrantedAuthority(user.role))
		return org.springframework.security.core.userdetails.User(user.email, user.passwordhash, authorities)
	}
}