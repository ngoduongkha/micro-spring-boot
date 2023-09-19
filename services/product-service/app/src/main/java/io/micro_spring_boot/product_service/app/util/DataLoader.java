package io.micro_spring_boot.product_service.app.util;

import io.micro_spring_boot.product_service.domain.aggregates.product.Product;
import io.micro_spring_boot.product_service.domain.aggregates.product.ProductType;
import io.micro_spring_boot.product_service.infra.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        if (productRepository.count() < 1) {
            Product[] products = {
                new Product(
                    "iphone_13",
                    "iPhone 13",
                    "iPhone 13",
                    1000d,
                    ProductType.SINGLE
                ),
                new Product(
                    "iphone_13_pro",
                    "iPhone 13 Pro",
                    "iPhone 13 Pro",
                    1200d,
                    ProductType.SINGLE
                ),
                new Product(
                    "iphone_13_pro_max",
                    "iPhone 13 Pro Max",
                    "iPhone 13 Pro Max",
                    1300d,
                    ProductType.SINGLE
                ),
                new Product(
                    "iphone_13_mini",
                    "iPhone 13 Mini",
                    "iPhone 13 Mini",
                    900d,
                    ProductType.SINGLE
                )
            };

            productRepository.saveAll(List.of(products));
        }
    }
}
