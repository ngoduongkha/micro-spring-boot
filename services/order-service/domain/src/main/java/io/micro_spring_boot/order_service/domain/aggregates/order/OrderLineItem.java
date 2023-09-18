package io.micro_spring_boot.order_service.domain.aggregates.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "order_line_items")
@IdClass(OrderLineItemId.class)
@RequiredArgsConstructor
@Setter
@Getter
public class OrderLineItem {
    @Id
    @Column(name = "order_id", nullable = false)
    private UUID orderId;

    @Id
    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column(nullable = false)
    private String skuCode;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;
}
