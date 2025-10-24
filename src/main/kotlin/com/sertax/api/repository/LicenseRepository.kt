package com.sertax.api.repository

import com.sertax.api.model.License
import org.springframework.data.jpa.repository.JpaRepository

interface LicenseRepository : JpaRepository<License, Long>