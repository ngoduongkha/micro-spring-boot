package com.microspringboot.apigateway

import org.springdoc.core.properties.SwaggerUiConfigParameters
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.gateway.route.RouteDefinitionLocator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*


@SpringBootApplication
@EnableDiscoveryClient
class ApiGatewayApplication

fun main(vararg args: String) {
    runApplication<ApiGatewayApplication>(*args)
}

@Configuration
class SwaggerConfig {
    @Bean
    fun openApiGroups(
        locator: RouteDefinitionLocator,
        swaggerUiParameters: SwaggerUiConfigParameters
    ): CommandLineRunner {
        return CommandLineRunner {
            Objects.requireNonNull(
                locator
                    .routeDefinitions.collectList().block()
            )
                .stream()
                .map { it.id }
                .filter { it.matches(Regex(".*-service")) }
                .map { it.replace("-service", "") }
                .forEach { swaggerUiParameters.addGroup(it) }
        }
    }
}
