package com.sertax.api.model

import jakarta.persistence.*

@Entity
@Table(name = "associations")
data class Association(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val associationid: Long = 0,
	
	@Column(nullable = false)
	val name: String,
	
	val address: String? = null,
	val phone: String? = null,
	val email: String? = null,
	val website: String? = null,
	val isactive: Boolean = true
)