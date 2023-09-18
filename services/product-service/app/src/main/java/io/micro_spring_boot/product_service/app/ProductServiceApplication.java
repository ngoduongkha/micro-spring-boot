package io.micro_spring_boot.product_service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(
    value = {
        "io.micro_spring_boot.product_service.infra.repositories"
    }
)
@EntityScan(
    value = {
        "io.micro_spring_boot.product_service.domain.aggregate",
    }
)
@EnableJpaAuditing
@EnableTransactionManagement
public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
