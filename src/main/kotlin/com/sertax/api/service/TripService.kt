package com.sertax.api.service

import com.sertax.api.model.Trip
import com.sertax.api.model.TaxiStop
import com.sertax.api.repository.TripRepository
import com.sertax.api.repository.TaxiStopRepository
import org.springframework.stereotype.Service

@Service
class TripService(private val repo: TripRepository) {
	fun findAll(): List<Trip> = repo.findAll()
	fun save(trip: Trip): Trip = repo.save(trip)
}