package com.microspringboot.productservice.app.dtos

import com.microspringboot.productservice.domain.aggregates.products.ProductType
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.hibernate.validator.constraints.Length

data class CreateProductRequest(
    @Schema(description = "Product SKU code", example = "SKU code", minLength = 3, maxLength = 50)
    @Length(max = 50) @NotBlank
    val skuCode: String,

    @Schema(description = "Product name", example = "Product name", minLength = 3, maxLength = 255)
    @Length(min = 3, max = 255)
    val name: String,

    @Schema(description = "Product description", example = "Product description", minLength = 3, maxLength = 255)
    @Length(min = 3, max = 255)
    val description: String,

    @Schema(description = "Product price", example = "1000.0", minimum = "0.0")
    @Positive
    val price: Double,

    val type: ProductType
)
