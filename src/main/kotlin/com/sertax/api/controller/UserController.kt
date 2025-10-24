package com.sertax.api.controller

import com.sertax.api.model.User
import com.sertax.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {
	
	@GetMapping
	fun getAllUsers(): List<User> = userService.findAll()
	
	@GetMapping("/{id}")
	fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
		val user: User? = userService.findById(id)
		return if (user != null) ResponseEntity.ok(user)
		else ResponseEntity.notFound().build()
	}
	
	@PostMapping
	fun createUser(@RequestBody user: User): ResponseEntity<User> =
		ResponseEntity.ok(userService.save(user))
	
	@PutMapping("/{id}")
	fun updateUser(@PathVariable id: Long, @RequestBody updated: User): ResponseEntity<User> {
		val existing: User? = userService.findById(id)
		return if (existing != null) {
			val merged = existing.copy(
				name = updated.name,
				email = updated.email,
				phonenumber = updated.phonenumber,
				passwordhash = updated.passwordhash,
				registrationdate = updated.registrationdate,
				legaltermsversion = updated.legaltermsversion,
				isactive = updated.isactive,
				verificationCode = updated.verificationCode,
				verificationCodeExpiresAt = updated.verificationCodeExpiresAt,
				hasSeenWizard = updated.hasSeenWizard,
				associationId = updated.associationId
			)
			ResponseEntity.ok(userService.save(merged))
		} else {
			ResponseEntity.notFound().build()
		}
	}
	
	@DeleteMapping("/{id}")
	fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
		return if (userService.existsById(id)) {
			userService.deleteById(id)
			ResponseEntity.noContent().build()
		} else {
			ResponseEntity.notFound().build()
		}
	}
}