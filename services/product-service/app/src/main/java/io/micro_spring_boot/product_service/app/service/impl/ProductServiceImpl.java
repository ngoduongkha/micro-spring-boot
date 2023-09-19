package io.micro_spring_boot.product_service.app.service.impl;

import io.micro_spring_boot.product_service.app.dto.CreateProductRequest;
import io.micro_spring_boot.product_service.app.dto.GetProductRequest;
import io.micro_spring_boot.product_service.app.dto.GetProductResponse;
import io.micro_spring_boot.product_service.app.service.ProductService;
import io.micro_spring_boot.product_service.domain.aggregates.product.Product;
import io.micro_spring_boot.product_service.infra.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void createProduct(CreateProductRequest productRequest) {
        Product product = new Product(
            productRequest.skuCode(),
            productRequest.name(),
            productRequest.description(),
            productRequest.price(),
            productRequest.type()
        );

        productRepository.save(product);
    }

    @Override
    public List<GetProductResponse> getAllProducts(GetProductRequest request) {
        List<Product> products = request.skuCode() == null ? productRepository.findAll() : productRepository.findBySkuCodeIn(request.skuCode());
        return products.stream().map(this::mapToProductResponse).toList();
    }

    @Override
    public GetProductResponse getProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow();
        return mapToProductResponse(product);
    }

    private GetProductResponse mapToProductResponse(Product product) {
        return new GetProductResponse(
            product.getId(),
            product.getSkuCode(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getType()
        );
    }
}
