package io.micro_spring_boot.order_service.domain.aggregates.order;

import io.micro_spring_boot.building_blocks.jpa.domain.aggregate.AggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends AggregateRoot<Order> {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private List<OrderLineItem> orderLineItems;
}
