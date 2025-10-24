package com.sertax.api.repository

import com.sertax.api.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>