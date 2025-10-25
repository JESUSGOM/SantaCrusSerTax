package com.sertax.api.controller

import com.sertax.api.model.Trip
import com.sertax.api.service.TripService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/trips")
class TripController(private val service: TripService, private val tripService: TripService) {
	@PostMapping
	fun createTrip(@RequestBody trip: Trip): Trip = tripService.createTrip(trip)
	
	@PutMapping("/{tripid}/assign/{driverid}")
	fun assignDriver(@PathVariable tripid: Long, @PathVariable driverid: Long): Trip? =
		tripService.assignDriver(tripid, driverid)
	
	@PutMapping("/{tripid}/cancel")
	fun cancelTrip(@PathVariable tripid: Long): Trip? = tripService.cancelTrip(tripid)
	
	@PutMapping("/{tripid}/complete")
	fun completeTrip(@PathVariable tripid: Long): Trip? = tripService.completeTrip(tripid)
	
	@GetMapping("/user/{userid}")
	fun getTripsByUser(@PathVariable userid: Long): List<Trip> = tripService.getTripsByUser(userid)
}