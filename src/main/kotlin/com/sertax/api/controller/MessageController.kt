package com.sertax.api.controller

import com.sertax.api.model.Message
import com.sertax.api.service.MessageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/messages")
class MessageController(private val service: MessageService) {
	@GetMapping fun all() = service.findAll()
	@PostMapping fun create(@RequestBody message: Message) = ResponseEntity.ok(service.save(message))
}