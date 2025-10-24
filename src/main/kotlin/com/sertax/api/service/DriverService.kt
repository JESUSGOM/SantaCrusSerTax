package com.sertax.api.service

import com.sertax.api.model.Driver
import com.sertax.api.repository.DriverRepository
import org.springframework.stereotype.Service

@Service
class DriverService(private val repo: DriverRepository) {
	fun findAll(): List<Driver> = repo.findAll()
	fun findById(id: Long): Driver? = repo.findById(id).orElse(null)
	fun save(driver: Driver): Driver = repo.save(driver)
}