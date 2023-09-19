package io.micro_spring_boot.order_service.app.dto;

public record InventoryResponse(
    String skuCode,
    Boolean isInStock
) { }
