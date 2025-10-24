package com.sertax.api.repository

import com.sertax.api.model.Rating
import org.springframework.data.jpa.repository.JpaRepository

interface RatingRepository : JpaRepository<Rating, Long>