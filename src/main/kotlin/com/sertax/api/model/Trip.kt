package com.sertax.api.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
@Table(name = "trips")
data class Trip(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val tripid: Long = 0,
	
	val userid: Long,
	val driverid: Long? = null,
	
	val requesttimestamp: ZonedDateTime? = null,
	val assignmenttimestamp: ZonedDateTime? = null,
	val pickuptimestamp: ZonedDateTime? = null,
	val completiontimestamp: ZonedDateTime? = null,
	
	@Column(nullable = false)
	val pickupaddress: String,
	
	@Column(nullable = false)
	val pickuplocation: String, // WKT o GeoJSON
	
	val destinationaddress: String? = null,
	val destinationlocation: String? = null,
	
	val estimatedcost: BigDecimal? = null,
	val finalcost: BigDecimal? = null,
	val numpassengers: Int? = null,
	val options: String? = null, // JSON
	
	val requestchannel: String? = null,
	val status: String? = null,
	val manualAssignmentAssociationId: Long? = null
)