package com.sertax.api.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtUtil {
	
	private val secretKey: SecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256)
	private val expirationMillis: Long = 3600000 // 1 hora
	
	fun generateToken(username: String, role: String): String {
		val now = Date()
		val expiry = Date(now.time + expirationMillis)
		
		return Jwts.builder()
			.setSubject(username)
			.claim("role", role)
			.setIssuedAt(now)
			.setExpiration(expiry)
			.signWith(secretKey)
			.compact()
	}
	
	fun validateToken(token: String): Boolean {
		return try {
			val claims = getClaims(token)
			!claims.expiration.before(Date())
		} catch (e: Exception) {
			false
		}
	}
	
	fun getUsername(token: String): String = getClaims(token).subject
	
	fun getRole(token: String): String = getClaims(token).get("role", String::class.java)
	
	fun getUsername(token: String): String = getClaims(token).subject
	
	fun getRole(token: String): String = getClaims(token).get("role", String::class.java)
	
	private fun getClaims(token: String): Claims =
		Jwts.parserBuilder()
			.setSigningKey(secretKey)
			.build()
			.parseClaimsJws(token)
			.body
}