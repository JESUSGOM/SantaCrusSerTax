package com.sertax.api.service

import com.sertax.api.model.DriverStatus
import com.sertax.api.model.DriverServiceStatus
import com.sertax.api.repository.DriverStatusRepository
import org.springframework.stereotype.Service
import java.time.ZonedDateTime

@Service
class DriverStatusService(private val repository: DriverStatusRepository) {
	
	fun updateStatus(driverid: Long, status: DriverServiceStatus, location: String?): DriverStatus {
		val existing = repository.findById(driverid).orElse(null)
		val updated = if (existing != null) {
			existing.copy(currentstatus = status, currentlocation = location, lastupdate = ZonedDateTime.now())
		} else {
			DriverStatus(driverid = driverid, currentstatus = status, currentlocation = location, lastupdate = ZonedDateTime.now())
		}
		return repository.save(updated)
	}
	
	fun getAvailableDrivers(): List<DriverStatus> =
		repository.findByCurrentstatus(DriverServiceStatus.FREE)
}