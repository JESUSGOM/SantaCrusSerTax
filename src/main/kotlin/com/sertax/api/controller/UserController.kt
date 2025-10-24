package com.sertax.api.controller

import com.sertax.api.model.User
import com.sertax.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {
	
	@GetMapping("/{id}")
	fun getUser(@PathVariable id: Long): ResponseEntity<User> =
		userService.findById(id)?.let { ResponseEntity.ok(it) }
			?: ResponseEntity.notFound().build()
	
	@GetMapping
	fun getAll(): List<User> = userService.findAll()
	
	@PostMapping
	fun createUser(@RequestBody user: User): ResponseEntity<User> =
		ResponseEntity.ok(userService.save(user))
}