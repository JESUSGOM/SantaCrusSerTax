package com.sertax.api.service

import com.sertax.api.model.License
import com.sertax.api.repository.LicenseRepository
import org.springframework.stereotype.Service

@Service
class LicenseService(private val repo: LicenseRepository) {
	fun findAll() = repo.findAll()
	fun findById(id: Long) = repo.findById(id)
	fun save(license: License) = repo.save(license)
}