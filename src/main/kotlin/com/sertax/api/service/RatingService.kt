package com.sertax.api.service

import com.sertax.api.model.Rating
import com.sertax.api.repository.RatingRepository
import org.springframework.stereotype.Service

@Service
class RatingService(private val repo: RatingRepository) {
	fun findAll(): List<Rating> = repo.findAll()
	fun save(rating: Rating): Rating = repo.save(rating)
}