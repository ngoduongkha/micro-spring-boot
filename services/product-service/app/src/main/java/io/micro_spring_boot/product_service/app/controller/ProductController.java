package io.micro_spring_boot.product_service.app.controller;

import java.util.List;

import io.micro_spring_boot.product_service.app.dto.ProductRequest;
import io.micro_spring_boot.product_service.app.dto.ProductResponse;
import io.micro_spring_boot.product_service.app.service.ProductService;
import io.micro_spring_boot.product_service.domain.aggregate.product.ProductType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UUID;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    public record ProductCriteria(
        @Nullable @UUID.List({}) List<java.util.UUID> ids,
        @NotNull @Length(min = 3, max = 255) String query,
        @Nullable @Min(0) Integer offset,
        @Nullable @Min(1) Integer limit,
        @NotNull ProductType type
    ) {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(@ParameterObject @Valid ProductCriteria type) {
        log.info("------ {}", type.toString());
        if (type.ids != null) {
            return productService.getProductByIds(type.ids);
        }
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductById(@PathVariable("id") java.util.UUID id) {
        return productService.getProductById(id);
    }
}
