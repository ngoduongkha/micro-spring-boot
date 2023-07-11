package microspringboot.productservice.aggregate.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import microspringboot.sharedkernel.domain.AggregateRoot;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product extends AggregateRoot<Product> {
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false, columnDefinition = "double precision")
    private Double price;
}
