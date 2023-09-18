package io.micro_spring_boot.product_service.app.service.impl;

import io.micro_spring_boot.product_service.app.dto.ProductRequest;
import io.micro_spring_boot.product_service.app.dto.ProductResponse;
import io.micro_spring_boot.product_service.app.service.ProductService;
import io.micro_spring_boot.product_service.domain.aggregate.product.Product;
import io.micro_spring_boot.product_service.infra.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = new Product(
            productRequest.getName(),
            productRequest.getDescription(),
            productRequest.getPrice(),
            productRequest.getType()
        );

        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    @Override
    public List<ProductResponse> getProductByIds(@NonNull List<UUID> ids) {
        List<Product> products = productRepository.findAllById(ids);
        return products.stream().map(this::mapToProductResponse).toList();
    }

    @Override
    public ProductResponse getProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow();
        return mapToProductResponse(product);
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .type(product.getType())
            .build();
    }
}
