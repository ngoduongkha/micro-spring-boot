package io.micro_spring_boot.product_service.infra.repositories;

import io.micro_spring_boot.product_service.domain.aggregate.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
