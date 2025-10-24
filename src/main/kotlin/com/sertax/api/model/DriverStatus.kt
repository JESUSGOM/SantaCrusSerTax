package com.sertax.api.model

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "driverstatus")
data class DriverStatus(
	
	@Id
	val driverid: Long,
	val currentstatus: String?, //Enum recomendado
	val currentlocation: String?, //GeoJSON o WKT
	val lastupdate: ZonedDateTime? = null
)