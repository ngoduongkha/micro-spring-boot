package io.micro_spring_boot.product_service.app.dto;

import io.micro_spring_boot.product_service.domain.aggregate.product.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private ProductType type;
}
