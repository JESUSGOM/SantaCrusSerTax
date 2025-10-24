package com.sertax.api.service

import com.sertax.api.security.jwt.JwtUtil
import com.sertax.api.repository.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.stereotype.Service

@Service
class AuthService(
	private val authManager: AuthenticationManager,
	private val jwtUtil: JwtUtil,
	private val userRepository: UserRepository
) {
	
	fun login(email: String, password: String): String {
		try {
			val auth = UsernamePasswordAuthenticationToken(email, password)
			authManager.authenticate(auth)
		} catch (e: AuthenticationException) {
			throw RuntimeException("Invalid credentials")
		}
		
		val user = userRepository.findByEmail(email)
			?: throw RuntimeException("User not found")
		
		return jwtUtil.generateToken(user.email, user.role)
	}
}