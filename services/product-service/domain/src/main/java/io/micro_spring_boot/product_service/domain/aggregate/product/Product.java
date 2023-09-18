package io.micro_spring_boot.product_service.domain.aggregate.product;

import io.micro_spring_boot.building_blocks.jpa.domain.aggregate.AggregateRoot;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

@Table(name = "products")
@Getter(value = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public @Entity class Product extends AggregateRoot<Product> {
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false, columnDefinition = "double precision")
    private Double price;

    @Column(nullable = false, columnDefinition = "product_type")
    @Enumerated(EnumType.STRING)
    @Type(PostgreSQLEnumType.class)
    private ProductType type;
}
