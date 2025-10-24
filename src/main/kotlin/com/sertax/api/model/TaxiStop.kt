package com.sertax.api.model

import jakarta.persistence.*

@Entity
@Table(name = "taxistops")
data class TaxiStop(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val stopid: Long = 0,
	
	@Column(nullable = false)
	val name: String,
	
	@Column(nullable = false)
	val location: String
)