package com.sertax.api.model

import jakarta.persistence.*

@Entity
@Table(name = "vehicles")
data class Vehicle(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val vehicleid: Long = 0,
	
	@Column(nullable = false)
	val licenseid: Long,
	
	val make: String? = null,
	val model: String? = null,
	
	@Column(nullable = false)
	val licenseplate: String,
	
	val photourl: String? = null,
	val ispmradapted: Boolean? = null,
	val allowsPets: Boolean = false
)