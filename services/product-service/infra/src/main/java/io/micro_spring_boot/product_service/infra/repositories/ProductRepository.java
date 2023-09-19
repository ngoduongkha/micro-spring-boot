package io.micro_spring_boot.product_service.infra.repositories;

import io.micro_spring_boot.building_blocks.jpa.domain.aggregate.AggregateRepository;
import io.micro_spring_boot.product_service.domain.aggregates.product.Product;

import java.util.List;

public interface ProductRepository extends AggregateRepository<Product> {
    List<Product> findBySkuCodeIn(List<String> skuCodes);
}
