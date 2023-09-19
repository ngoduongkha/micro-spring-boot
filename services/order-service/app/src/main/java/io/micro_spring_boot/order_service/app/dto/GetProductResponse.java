package io.micro_spring_boot.order_service.app.dto;

import java.util.UUID;

public record GetProductResponse(
    UUID id,
    String skuCode,
    String name,
    String description,
    Double price,
    ProductType type
) { }
