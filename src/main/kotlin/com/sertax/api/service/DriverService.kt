package com.sertax.api.service

import com.sertax.api.model.Driver
import com.sertax.api.repository.DriverRepository
import org.springframework.stereotype.Service

@Service
class DriverService(private val repository: DriverRepository) {
	
	fun findAll(): List<Driver> = repository.findAll()
	
	fun findById(driverid: Long): Driver? = repository.findById(driverid).orElse(null)
	
	fun create(driver: Driver): Driver = repository.save(driver)
	
	fun update(driverid: Long, updated: Driver): Driver? {
		val existing = repository.findById(driverid).orElse(null) ?: return null
		val merged = existing.copy(
			name = updated.name,
			licenseid = updated.licenseid,
			role = updated.role,
			passwordhash = updated.passwordhash,
			isactive = updated.isactive,
			association_id = updated.association_id
		)
		return repository.save(merged)
	}
	
	fun delete(driverid: Long): Boolean {
		return if (repository.existsById(driverid)) {
			repository.deleteById(driverid)
			true
		} else {
			false
		}
	}
}