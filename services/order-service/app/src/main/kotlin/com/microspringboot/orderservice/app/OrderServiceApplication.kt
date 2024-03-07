package com.microspringboot.orderservice.app

import jakarta.annotation.PostConstruct
import org.springframework.boot.Banner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.time.ZoneId
import java.util.*
import java.util.TimeZone.getTimeZone

@SpringBootApplication(scanBasePackages = ["com.microspringboot.order_service"])
@EnableJpaAuditing
@EnableJpaRepositories(value = ["com.microspringboot.order_service.infra.repositories"])
@EntityScan(value = ["com.microspringboot.order_service.domain.aggregates"])
class OrderServiceApplication {
    @PostConstruct
    fun started() {
        TimeZone.setDefault(getTimeZone(ZoneId.of("UTC")))
    }
}

fun main(args: Array<String>) {
    runApplication<OrderServiceApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
        webApplicationType = WebApplicationType.REACTIVE
    }
}
