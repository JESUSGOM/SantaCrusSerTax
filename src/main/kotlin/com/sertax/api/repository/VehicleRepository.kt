package com.sertax.api.repository

import com.sertax.api.model.Vehicle
import org.springframework.data.jpa.repository.JpaRepository

interface VehicleRepository : JpaRepository<Vehicle, Long>