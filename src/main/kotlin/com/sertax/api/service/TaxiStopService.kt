package com.sertax.api.service

import com.sertax.api.model.Trip
import com.sertax.api.model.TaxiStop
import com.sertax.api.repository.TripRepository
import com.sertax.api.repository.TaxiStopRepository
import org.springframework.stereotype.Service

@Service
class TaxiStopService(private val repo: TaxiStopRepository) {
	fun findAll(): List<TaxiStop> = repo.findAll()
	fun save(stop: TaxiStop): TaxiStop = repo.save(stop)
}