package com.sertax.api.repository

import com.sertax.api.model.DriverStatus
import com.sertax.api.model.DriverServiceStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DriverStatusRepository : JpaRepository<DriverStatus, Long> {
	fun findByCurrentstatus(status: DriverServiceStatus): List<DriverStatus>
}