package com.sertax.api.repository

import com.sertax.api.model.Driver
import org.springframework.data.jpa.repository.JpaRepository

interface DriverRepository : JpaRepository<Driver, Long>