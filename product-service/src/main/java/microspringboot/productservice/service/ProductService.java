package microspringboot.productservice.service;

import microspringboot.productservice.ProductServiceApplication;
import microspringboot.productservice.aggregate.product.Product;
import microspringboot.productservice.dto.CreateProductDto;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    @NonNull
    List<Product> findAll();
    @NonNull
    List<Product> findAllByCategory(String category);

    @NonNull
    Product save(@NonNull CreateProductDto product);

    Optional<Product> findById(UUID id);
}
