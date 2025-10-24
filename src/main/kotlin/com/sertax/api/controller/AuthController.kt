package com.sertax.api.controller

import com.sertax.api.service.AuthService

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class LoginRequest(val email: String, val password: String)
data class LoginResponse(val token: String)

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {
	
	@PostMapping("/login")
	fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
		val token = authService.login(request.email, request.password)
		return ResponseEntity.ok(LoginResponse(token))
	}
}