package io.micro_spring_boot.product_service.app.dto;

import org.springframework.lang.Nullable;

import java.util.List;

public record GetProductRequest(
    @Nullable
    List<String> skuCode
) {
}
