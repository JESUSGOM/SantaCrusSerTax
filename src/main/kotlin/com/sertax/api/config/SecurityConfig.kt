package com.sertax.api.config

import com.sertax.api.security.jwt.JwtFilter
import com.sertax.api.service.UserDetailsServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig(
	private val jwtFilter: JwtFilter,
	private val userDetailsService: UserDetailsServiceImpl
) {
	
	@Bean
	fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
		return http
			.csrf { it.disable() }
			.authorizeHttpRequests {
				it.requestMatchers("/auth/**").permitAll()
					.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
					.requestMatchers("/drivers/**").hasAuthority("ROLE_DRIVER")
					.anyRequest().authenticated()
			}
			.sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
			.build()
	}
	
	@Bean
	fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager =
		config.authenticationManager
}