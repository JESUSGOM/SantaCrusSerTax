package com.sertax.api.model

import jakarta.persistence.*

@Entity
@Table(name = "drivers")
data class Driver(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val driverid: Long = 0,
	
	@Column(nullable = false)
	val licenseid: Long,
	
	@Column(nullable = false)
	val name: String,
	
	@Column(nullable = false)
	val role: String, // Enum recomendado
	
	@Column(nullable = false)
	val passwordhash: String,
	
	val isactive: Boolean? = true,
	
	val associationId: Long? = null
)