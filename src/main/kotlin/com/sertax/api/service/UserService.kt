package com.sertax.api.service

import com.sertax.api.model.User
import com.sertax.api.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
	
	fun findAll(): List<User> = userRepository.findAll()
	
	fun findById(id: Long): User? = userRepository.findById(id).orElse(null)
	
	fun save(user: User): User = userRepository.save(user)
	
	fun deleteById(id: Long) = userRepository.deleteById(id)
	
	fun existsById(id: Long): Boolean = userRepository.existsById(id)
}