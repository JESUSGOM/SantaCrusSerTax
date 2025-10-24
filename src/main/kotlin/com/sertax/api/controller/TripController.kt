package com.sertax.api.controller

import com.sertax.api.model.Trip
import com.sertax.api.model.TaxiStop
import com.sertax.api.service.TripService
import com.sertax.api.service.TaxiStopService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/trips")
class TripController(private val service: TripService) {
	@GetMapping fun all() = service.findAll()
	@PostMapping fun create(@RequestBody trip: Trip) = ResponseEntity.ok(service.save(trip))
}