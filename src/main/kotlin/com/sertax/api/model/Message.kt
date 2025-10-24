package com.sertax.api.model

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "messages")
data class Message(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val messageid: Long = 0,
	
	val tripid: Long,
	val senderid: Long,
	val receiverid: Long,
	val content: String,
	val timestamp: ZonedDateTime? = null
)