import com.sertax.api.model.Driver
import com.sertax.api.service.DriverService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/drivers")
class DriverController(private val driverService: DriverService) {
    
    @GetMapping
    fun getAllDrivers(): ResponseEntity<List<Driver>> =
        ResponseEntity.ok(driverService.findAll())
    
    @GetMapping("/{driverid}")
    fun getDriverById(@PathVariable driverid: Long): ResponseEntity<Driver> {
        val driver = driverService.findById(driverid)
        return if (driver != null) ResponseEntity.ok(driver)
        else ResponseEntity.notFound().build()
    }
    
    @PostMapping
    fun createDriver(@RequestBody driver: Driver): ResponseEntity<Driver> {
        val created = driverService.create(driver)
        return ResponseEntity.ok(created)
    }
    
    @PutMapping("/{driverid}")
    fun updateDriver(@PathVariable driverid: Long, @RequestBody updated: Driver): ResponseEntity<Driver> {
        val result = driverService.update(driverid, updated)
        return if (result != null) ResponseEntity.ok(result)
        else ResponseEntity.notFound().build()
    }
    
    @DeleteMapping("/{driverid}")
    fun deleteDriver(@PathVariable driverid: Long): ResponseEntity<Void> {
        val deleted = driverService.delete(driverid)
        return if (deleted) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}