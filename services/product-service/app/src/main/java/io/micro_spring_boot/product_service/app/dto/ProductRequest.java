package io.micro_spring_boot.product_service.app.dto;

import io.micro_spring_boot.product_service.domain.aggregate.product.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @Length(min = 3, max = 255)
    @Schema(description = "Product name", example = "Product name", minLength = 3, maxLength = 255)
    private String name;

    @Length(min = 3, max = 255)
    @Schema(description = "Product description", example = "Product description", minLength = 3, maxLength = 255)
    private String description;

    @Positive
    @Schema(description = "Product price", example = "1000.0", minimum = "0.0")
    private Double price;

    private ProductType type;
}
