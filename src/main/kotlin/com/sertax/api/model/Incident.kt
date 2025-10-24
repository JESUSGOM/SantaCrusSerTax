package com.sertax.api.model

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "incidents")
data class Incident(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val incidentid: Long = 0,
	
	val tripid: Long,
	val reporterid: Long,
	val description: String,
	val timestamp: ZonedDateTime? = null,
	val resolved: Boolean = false
)