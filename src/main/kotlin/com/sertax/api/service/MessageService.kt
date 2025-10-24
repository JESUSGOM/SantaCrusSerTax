package com.sertax.api.service

import com.sertax.api.model.Message
import com.sertax.api.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(private val repo: MessageRepository) {
	fun findAll(): List<Message> = repo.findAll()
	fun save(message: Message): Message = repo.save(message)
}