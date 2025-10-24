package com.sertax.api.model

import com.sertax.api.model.Driver
import com.sertax.api.service.DriverService
import org.springframework.http.ReponseEntity
import org.springframework.web.vind.annotation.*

@RestController
@RequestMapping("/drivers")
class DriverController(private val service: DriverService) {
    @GetMapping
        fun getAll(): List<Driver> = service.findAll()

        @GetMapping("/{id}")
        fun getById(@PathVariable id: Long): ResponseEntity<Driver> =
            service.findById(id)?.let { ResponseEntity.ok(it) }
                ?: ResponseEntity.notFound().build()

        @PostMapping
        fun create(@RequestBody driver: Driver): ResponseEntity<Driver> =
            ResponseEntity.ok(service.save(driver))
}
