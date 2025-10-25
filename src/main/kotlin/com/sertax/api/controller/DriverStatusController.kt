package com.sertax.api.controller

import com.sertax.api.model.DriverStatus
import com.sertax.api.model.DriverStatusService
import com.sertex.api.model.DriverServiceStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/driver-status")
class DriverStatusController(private val service: DriverStatusService) {
	
	@PutMapping("/{driverid}")
	fun updateStatus(
		@PathVariable driverid: Long,
		@RequestParam status: DriverServiceStatus,
		@RequestParam location: String?
	): DriverStatus = service.updateStatus(driverid, status, location)
	
	@GetMapping("/available")
	fun getAvailableDrivers(): List<DriverStatus> = service.getAvailableDrivers()
}