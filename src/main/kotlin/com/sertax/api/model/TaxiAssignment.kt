package com.sertax.api.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class TaxiAssignment(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,
	
	val requestId: Long,
	val driverId: Long,
	val licenseId: Long,
	
	val assignedAt: LocalDateTime = LocalDateTime.now(),
	var accepted: Boolean = false,
	var cancelled: Boolean = false
)