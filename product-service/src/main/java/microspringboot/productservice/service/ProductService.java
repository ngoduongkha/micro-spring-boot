package microspringboot.productservice.service;

import microspringboot.productservice.aggregate.product.Product;
import microspringboot.productservice.dto.ProductRequest;
import microspringboot.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
