package com.sertax.api.repository

import com.sertax.api.model.TaxiStop
import org.springframework.data.jpa.repository.JpaRepository

interface TaxiStopRepository : JpaRepository<TaxiStop, Long>