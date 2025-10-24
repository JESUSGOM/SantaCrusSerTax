package com.sertax.api.service

import com.sertax.api.model.Vehicle
import com.sertax.api.repository.VehicleRepository
import org.springframework.stereotype.Service

@Service
class VehicleService(private val repo: VehicleRepository) {
	fun findAll(): List<Vehicle> = repo.findAll()
	fun findById(id: Long): Vehicle? = repo.findById(id).orElse(null)
	fun save(vehicle: Vehicle): Vehicle = repo.save(vehicle)
}