package microspringboot.productservice.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import microspringboot.productservice.aggregate.product.Product;
import microspringboot.productservice.dto.CreateProductDto;
import microspringboot.productservice.repository.ProductRepository;
import microspringboot.productservice.service.ProductService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @PostConstruct
    public void init() {
        List<Product> products = List.of(
                new Product("Product 1", 100, "Red", "Category 1"),
                new Product("Product 2", 200, "Blue", "Category 2"),
                new Product("Product 3", 300, "Green", "Category 3"),
                new Product("Product 4", 400, "Yellow", "Category 4"),
                new Product("Product 5", 500, "Orange", "Category 1"),
                new Product("Product 6", 600, "Purple", "Category 2"),
                new Product("Product 7", 700, "Black", "Category 3"),
                new Product("Product 8", 800, "White", "Category 4")
        );
        productRepository.saveAll(products);
    }

    @Override
    @NonNull
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @NonNull
    public List<Product> findAllByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    @Override
    @NonNull
    @Transactional
    public Product save(@NonNull CreateProductDto product) {
        return productRepository.save(new Product(product.getName(), product.getPrice(), product.getColor(), product.getCategory()));
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }
}
