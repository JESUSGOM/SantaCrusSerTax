package com.sertax.api.model

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "users")
data class User(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	val userid: Long = 0,
	
	@Column(nullable = false)
	var name: String,
	
	@Column(nullable = false, unique = true)
	var email: String,
	
	@Column(nullable = false)
	var phonenumber: String,
	
	@Column(nullable = false)
	var passwordhash: String,
	
	var registrationdate: ZonedDateTime? = null,
	var legaltermsversion: String? = null,
	var isactive: Boolean? = true,
	var verificationCode: String? = null,
	var verificationCodeExpiresAt: ZonedDateTime? = null,
	var hasSeenWizard: Boolean = false,
	
	@Column(name = "association_id")
	var associationId: Long? = null
)