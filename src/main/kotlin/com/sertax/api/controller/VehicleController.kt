package com.sertax.api.controller

import com.sertax.api.model.Vehicle
import com.sertax.api.service.VehicleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vehicles")
class VehicleController(private val service: VehicleService) {
	
	@GetMapping
	fun getAll(): List<Vehicle> = service.findAll()
	
	@GetMapping("/{id}")
	fun getById(@PathVariable id: Long)= service.findById(id)
	
	@PostMapping
	fun create(@RequestBody vehicle: Vehicle): ResponseEntity<Vehicle> =
		ResponseEntity.ok(service.save(vehicle))
}