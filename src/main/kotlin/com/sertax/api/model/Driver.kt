package com.sertax.api.model

import jakarta.persistence.*
import jakarta.validation.constraints.*
import java.time.ZonedDateTime

@Entity
@Table(name = "drivers")
data class Driver(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val driverid: Long = 0,
	
	@Column(nullable = false)
	val licenseid: Long,
	
	@Column(nullable = false)
	@NotBlank
	val name: String,
	
	@Column(nullable = false)
	val role: String, // Enum recomendado
	
	@Column(nullable = false)
	val passwordhash: String,
	
	val isactive: Boolean? = true,
	
	val associationId: Long? = null
)

enum class DriverRole {
	OWNER, SALARIED
}