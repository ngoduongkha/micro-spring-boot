package microspringboot.productservice.util;

import lombok.RequiredArgsConstructor;
import microspringboot.productservice.aggregate.product.Product;
import microspringboot.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() < 1) {
            Product product = new Product();
            product.setName("iPhone 13");
            product.setDescription("iPhone 13");
            product.setPrice(1000d);

            productRepository.save(product);
        }
    }
}
