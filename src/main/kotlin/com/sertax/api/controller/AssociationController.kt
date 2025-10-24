package com.sertax.api.controller

import com.sertax.api.model.Association
import com.sertax.api.service.AssociationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/associations")
class AssociationController(private val service: AssociationService) {
	
	@GetMapping
	fun getAll(): List<Association> = service.findAll()
	
	@GetMapping("/{id}")
	fun getById(@PathVariable id: Long): ResponseEntity<Association> {
		val association = service.findById(id)
		return if (association != null) ResponseEntity.ok(association)
		else ResponseEntity.notFound().build()
	}
	
	@PostMapping
	fun create(@RequestBody association: Association): ResponseEntity<Association> =
		ResponseEntity.ok(service.save(association))
	
	@PutMapping("/{id}")
	fun update(@PathVariable id: Long, @RequestBody updated: Association): ResponseEntity<Association> {
		val result = service.update(id, updated)
		return if (result != null) ResponseEntity.ok(result)
		else ResponseEntity.notFound().build()
	}
	
	@DeleteMapping("/{id}")
	fun delete(@PathVariable id: Long): ResponseEntity<Void> {
		return if (service.existsById(id)) {
			service.deleteById(id)
			ResponseEntity.noContent().build()
		} else {
			ResponseEntity.notFound().build()
		}
	}
}