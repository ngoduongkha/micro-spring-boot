package io.micro_spring_boot.order_service.infra.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(value = { "io.micro_spring_boot.order_service.infra.repositories" })
@EntityScan(value = { "io.micro_spring_boot.order_service.domain.aggregates" })
public class JpaConfiguration {
}
