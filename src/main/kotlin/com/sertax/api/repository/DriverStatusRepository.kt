package com.sertax.api.repository

import com.sertax.api.model.DriverStatus
import org.springframework.data.jpa.repository.JpaRepository

interface DriverStatusRepository : JpaRepository<DriverStatus, Long>