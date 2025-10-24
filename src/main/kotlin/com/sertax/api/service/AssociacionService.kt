package com.sertax.api.service

import com.sertax.api.model.Association
import com.sertax.api.repository.AssociationRepository
import org.springframework.stereotype.Service

@Service
class AssociationService(private val repository: AssociationRepository) {
	
	fun findAll(): List<Association> = repository.findAll()
	
	fun findById(id: Long): Association? = repository.findById(id).orElse(null)
	
	fun save(association: Association): Association = repository.save(association)
	
	fun update(id: Long, updated: Association): Association? {
		val existing = findById(id) ?: return null
		val merged = existing.copy(
			name = updated.name,
			address = updated.address,
			phone = updated.phone,
			email = updated.email,
			website = updated.website,
			isactive = updated.isactive
		)
		return repository.save(merged)
	}
	
	fun deleteById(id: Long) = repository.deleteById(id)
	
	fun existsById(id: Long): Boolean = repository.existsById(id)
}