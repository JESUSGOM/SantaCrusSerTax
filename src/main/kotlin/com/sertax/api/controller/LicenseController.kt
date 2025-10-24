package com.sertax.api.controller

import com.sertax.api.model.License
import com.sertax.api.service.LicenseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/licenses")
class LicenseController(private val service: LicenseService) {
	@GetMapping
	fun getAll() = service.findAll()
	
	@GetMapping("/{id}")
	fun getById(@PathVariable id: Long) = service.findById(id)
	
	@PostMapping
	fun create(@RequestBody license: License) = service.save(license)
}