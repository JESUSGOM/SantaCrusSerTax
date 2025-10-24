package com.sertax.api.repository

import com.sertax.api.model.Trip
import org.springframework.data.jpa.repository.JpaRepository

interface TripRepository : JpaRepository<Trip, Long>