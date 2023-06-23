package microspringboot.productservice.aggregate.product;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import microspringboot.sharedkernel.domain.AggregateRoot;
import microspringboot.sharedkernel.domain.ConstructorUsedByJPAOnly;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Product extends AggregateRoot<Product> {
    private String name;
    private double price;
    private String color;
    private String category;

    @ConstructorUsedByJPAOnly
    public Product() { }
}
