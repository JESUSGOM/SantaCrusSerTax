package com.sertax.api.repository

import com.sertax.api.model.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository :  JpaRepository<Message, Long>