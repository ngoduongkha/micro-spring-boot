package microspringboot.productservice.repository;

import microspringboot.productservice.aggregate.product.Product;
import microspringboot.sharedkernel.repository.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProductRepository extends Repository<Product> {
    @NonNull
    @Query("""
        SELECT p
        FROM Product p
        WHERE p.category ILIKE '%' || :category || '%'
    """)
    List<Product> findAllByCategory(String category);
}
