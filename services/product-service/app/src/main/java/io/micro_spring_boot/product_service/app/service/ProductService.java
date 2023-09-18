package io.micro_spring_boot.product_service.app.service;

import io.micro_spring_boot.product_service.app.dto.ProductRequest;
import io.micro_spring_boot.product_service.app.dto.ProductResponse;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    void createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
    List<ProductResponse> getProductByIds(@NonNull List<UUID> ids);
    ProductResponse getProductById(UUID id);
}
