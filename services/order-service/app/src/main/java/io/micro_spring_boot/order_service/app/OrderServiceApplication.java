package io.micro_spring_boot.order_service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = {
        "io.micro_spring_boot.order_service.app",
        "io.micro_spring_boot.order_service.infra.configurations",
    }
)
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}