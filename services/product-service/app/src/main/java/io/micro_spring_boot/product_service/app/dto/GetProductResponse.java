package io.micro_spring_boot.product_service.app.dto;

import io.micro_spring_boot.product_service.domain.aggregates.product.ProductType;

import java.util.UUID;


public record GetProductResponse(
    UUID id,
    String skuCode,
    String name,
    String description,
    Double price,
    ProductType type
) { }
