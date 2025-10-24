package com.sertax.api.service

import com.sertax.api.model.Incident
import com.sertax.api.repository.IncidentRepository
import org.springframework.stereotype.Service

@Service
class IncidentService(private val repo: IncidentRepository) {
	fun findAll(): List<Incident> = repo.findAll()
	fun save(incident: Incident): Incident = repo.save(incident)
}