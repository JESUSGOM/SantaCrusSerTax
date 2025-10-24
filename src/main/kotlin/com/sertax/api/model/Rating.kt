package com.sertax.api.model

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "ratings")
data class Rating(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val ratingid: Long = 0,
	
	val tripid: Long,
	val userid: Long,
	val driverid: Long,
	
	val rating: Int,
	val comment: String? = null,
	val timestamp: ZonedDateTime? = null
)