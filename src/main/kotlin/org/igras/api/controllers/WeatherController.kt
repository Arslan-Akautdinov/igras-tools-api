package org.igras.api.controllers

import org.igras.api.models.WeatherAverageIndexedCollection
import org.igras.api.service.WeatherCalculationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.FileNotFoundException

@RestController
@RequestMapping("test")
class WeatherController {
    lateinit var service: WeatherCalculationService

    @Autowired
    fun constructor(service: WeatherCalculationService) {
        this.service = service
    }

    @GetMapping("/data")
    fun getData(): WeatherAverageIndexedCollection {
        val url = javaClass.getResource("/static/21-04-2021.txt")?.file
            ?: throw FileNotFoundException()
        return service.readData(url)
    }
}


