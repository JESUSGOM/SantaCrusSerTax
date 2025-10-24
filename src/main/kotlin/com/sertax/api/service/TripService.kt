package com.sertax.api.service

import com.sertax.api.model.Trip
import com.sertax.api.model.TripStatus
import com.sertax.api.repository.TripRepository
import org.springframework.stereotype.Service

@Service
class TripService(private val tripRepository: TripRepository) {
	
	fun createTrip(trip: Trip): Trip {
		val newTrip = trip.copy(
			requesttimestamp = ZonedDateTime.now(),
			status = TripStatus.PENDING
		)
		return tripRepository.save(newTrip)
	}
	
	fun assignDriver(tripid: Long, driverid: Long): Trip? {
		val trip = tripRepository.findById(tripid).orElse(null) ?: return null
		val updated = trip.copy(
			driverid = driverid,
			assignmenttimestamp = ZonedDateTime.now(),
			status = TripStatus.ASSIGNED
		)
		return tripRepository.save(updated)
	}
	
	fun cancelTrip(tripid: Long): Trip? {
		val trip = tripRepository.findById(tripid).orElse(null) ?: return null
		val cancelled = trip.copy(status = TripStatus.CANCELLED)
		return tripRepository.save(cancelled)
	}
	
	fun completeTrip(tripid: Long): Trip? {
		val trip = tripRepository.findById(tripid).orElse(null) ?: return null
		val completed = trip.copy(
			completiontimestamp = ZonedDateTime.now(),
			status = TripStatus.COMPLETED
		)
		return tripRepository.save(completed)
	}
	
	fun getTripsByUser(userid: Long): List<Trip> = tripRepository.findByUserid(userid)
}