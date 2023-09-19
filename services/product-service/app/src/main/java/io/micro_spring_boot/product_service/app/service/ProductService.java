package io.micro_spring_boot.product_service.app.service;

import io.micro_spring_boot.product_service.app.dto.CreateProductRequest;
import io.micro_spring_boot.product_service.app.dto.GetProductRequest;
import io.micro_spring_boot.product_service.app.dto.GetProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void createProduct(CreateProductRequest productRequest);
    List<GetProductResponse> getAllProducts(GetProductRequest request);
    GetProductResponse getProductById(UUID id);
}
