package com.sertax.api.security.jwt

import com.sertax.api.service.UserDetailsServiceImpl
import io.jsonwebtoken.JwtException
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.GenericFilterBean

@Component
class JwtFilter(
	private val jwtUtil: JwtUtil,
	private val userDetailsService: UserDetailsServiceImpl
) : GenericFilterBean() {
	
	override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
		val httpRequest = request as HttpServletRequest
		val httpResponse = response as HttpServletResponse
		
		val authHeader = httpRequest.getHeader("Authorization")
		val token = authHeader?.takeIf { it.startsWith("Bearer ") }?.removePrefix("Bearer ")
		
		if (token != null) {
			try {
				if (jwtUtil.validateToken(token)) {
					val username = jwtUtil.getUsername(token)
					val userDetails = userDetailsService.loadUserByUsername(username)
					
					val auth = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
					auth.details = WebAuthenticationDetailsSource().buildDetails(httpRequest)
					
					SecurityContextHolder.getContext().authentication = auth
				}
			} catch (e: JwtException) {
				httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token")
				return
			}
		}
		
		chain.doFilter(request, response)
	}
}