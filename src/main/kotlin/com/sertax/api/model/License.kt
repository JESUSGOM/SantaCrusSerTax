package com.sertax.api.model

import jakarta.persistence.*

@Entity
@Table(name = "licenses")
data class License(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val licenseid: Long = 0,
	
	@Column(nullable = false)
	val licensenumber: String,
	
	val associationid: Long? = null
)