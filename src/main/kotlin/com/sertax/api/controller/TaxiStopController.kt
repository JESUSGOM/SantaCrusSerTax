package com.sertax.api.controller

import com.sertax.api.model.Trip
import com.sertax.api.model.TaxiStop
import com.sertax.api.service.TripService
import com.sertax.api.service.TaxiStopService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/taxistops")
class TaxiStopController(private val service: TaxiStopService) {
	@GetMapping fun all() = service.findAll()
	@PostMapping fun create(@RequestBody stop: TaxiStop) = ResponseEntity.ok(service.save(stop))
}