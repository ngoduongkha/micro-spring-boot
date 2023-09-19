package io.micro_spring_boot.product_service.app.dto;

import io.micro_spring_boot.product_service.domain.aggregates.product.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record CreateProductRequest(
    @Length(max = 50)
    @NotBlank
    @Schema(description = "Product SKU code", example = "SKU code", minLength = 3, maxLength = 50)
    String skuCode,

    @Length(min = 3, max = 255)
    @Schema(description = "Product name", example = "Product name", minLength = 3, maxLength = 255)
    String name,

    @Length(min = 3, max = 255)
    @Schema(description = "Product description", example = "Product description", minLength = 3, maxLength = 255)
    String description,

    @Positive
    @Schema(description = "Product price", example = "1000.0", minimum = "0.0")
    Double price,
    ProductType type
) { }
