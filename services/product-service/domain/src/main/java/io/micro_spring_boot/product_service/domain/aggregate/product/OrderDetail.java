package io.micro_spring_boot.product_service.domain.aggregate.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "order_details")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public @Entity class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(name = "order_id", nullable = false, columnDefinition = "uuid")
    private UUID orderId;

    @ManyToOne(targetEntity = Product.class)
    private Product product;

    @Column(nullable = false, columnDefinition = "integer")
    private int quantity;
}
