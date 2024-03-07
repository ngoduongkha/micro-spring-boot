package com.microspringboot.productservice.app

import io.swagger.v3.oas.models.OpenAPI
import jakarta.annotation.PostConstruct
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.time.ZoneId
import java.util.*
import java.util.TimeZone.getTimeZone


@SpringBootApplication(scanBasePackages = [
    "com.microspringboot.productservice",
    "com.microspringboot.building_blocks",
])
@EnableJpaAuditing
@EnableJpaRepositories(value = ["com.microspringboot.productservice.infra.repositories"])
@EntityScan(value = ["com.microspringboot.productservice.domain.aggregates"])
class ProductServiceApplication {
    @PostConstruct
    fun started() {
        TimeZone.setDefault(getTimeZone(ZoneId.of("UTC")))
    }
}

fun main(vararg args: String) {
    runApplication<ProductServiceApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}


@Configuration
class SpringFoxConfig {
    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("product")
            .packagesToScan("com.microspringboot.productservice.app.controllers")
            .build()
    }
}