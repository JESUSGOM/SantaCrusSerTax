package com.sertax.api.model

import com.sertex.api.model.DriverServiceStatus
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "driverstatus")
data class DriverStatus(
	@Id
	val driverid: Long,
	
	@Enumerated(EnumType.STRING)
	val currentstatus: DriverServiceStatus? = DriverServiceStatus.OFFLINE,
	
	val currentlocation: String? = null,
	
	val lastupdate: ZonedDateTime? = ZonedDateTime.now()
)