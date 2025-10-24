package com.sertax.api.controller

import com.sertax.api.model.Rating
import com.sertax.api.service.RatingService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ratings")
class RatingController(private val service: RatingService) {
	@GetMapping fun all() = service.findAll()
	@PostMapping fun create(@RequestBody rating: Rating) = ResponseEntity.ok(service.save(rating))
}