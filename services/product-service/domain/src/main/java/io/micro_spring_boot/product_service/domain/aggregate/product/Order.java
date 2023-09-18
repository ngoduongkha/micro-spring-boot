package io.micro_spring_boot.product_service.domain.aggregate.product;

import io.micro_spring_boot.building_blocks.jpa.domain.aggregate.AggregateRoot;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public @Entity class Order extends AggregateRoot<Order> {
    @OneToMany(targetEntity = OrderDetail.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id", referencedColumnName = "id", updatable = false, insertable = false)
    private List<OrderDetail> orderDetail;

    @Column(nullable = false, columnDefinition = "double precision")
    private Double totalPrice;
}
