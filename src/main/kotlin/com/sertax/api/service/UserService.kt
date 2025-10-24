package com.sertax.api.service

import com.sertax.user.model.User
import com.sertax.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
	
	fun findById(id: Long): User? = userRepository.findById(id).orElse(null)
	
	fun save(user: User): User = userRepository.save(user)
	
	fun findAll(): List<User> = userRepository.findAll()
}