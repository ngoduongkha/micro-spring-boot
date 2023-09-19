package io.micro_spring_boot.product_service.app.controller;

import io.micro_spring_boot.product_service.app.dto.CreateProductRequest;
import io.micro_spring_boot.product_service.app.dto.GetProductRequest;
import io.micro_spring_boot.product_service.app.dto.GetProductResponse;
import io.micro_spring_boot.product_service.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody CreateProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetProductResponse> getAllProducts(GetProductRequest request) {
        return productService.getAllProducts(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetProductResponse getProductById(@PathVariable("id") UUID id) {
        return productService.getProductById(id);
    }
}
