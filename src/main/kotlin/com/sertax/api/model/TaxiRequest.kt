package com.sertax.api.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class TaxiRequest {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val id: Long = 0,
	
	val userId: Long,
	val pickupLocation: String,
	val destination: String?,
	val passengers: Int = 1,
	val pmr: Boolean = false,
	val withPet: Boolean = false,
	val scheduledTime: LocalDateTime? = null,
	
	@Enumerated(EnumType.STRING)
	var status: RequestStatus = RequestStatus.PENDING,
	
	val createdAt: LocalDateTime = LocalDateTime.now()
	)
	
	enum class RequestStatus {
		PENDING, ASSIGNED, CANCELLED, COMPLETED, REJECTED
	}