package com.sertax.api.repository

import com.sertax.api.model.Trip
import com.sertax.api.model.TripStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TripRepository : JpaRepository<Trip, Long> {
	fun findByUserid(userid: Long): List<Trip>
	fun findByStatus(status: TripStatus): List<Trip>
}