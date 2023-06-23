package microspringboot.productservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import microspringboot.productservice.aggregate.product.Product;
import microspringboot.productservice.dto.CreateProductDto;
import microspringboot.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

//    @GetMapping("{category}")
//    public List<Product> getProductsByCategory(@PathVariable("category") String category) {
//        return productService.findAllByCategory(category);
//    }

    @GetMapping("{id}")
    public Optional<Product> getProductById(@PathVariable("id") UUID id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody @Valid CreateProductDto product) {
        return productService.save(product);
    }
}
