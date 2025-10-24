package com.sertax.api.repository

import com.sertax.api.model.Incident
import org.springframework.data.jpa.repository.JpaRepository

interface IncidentRepository : JpaRepository<Incident, Long>