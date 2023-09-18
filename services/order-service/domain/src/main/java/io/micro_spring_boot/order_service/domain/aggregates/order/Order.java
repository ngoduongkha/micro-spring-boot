package io.micro_spring_boot.order_service.domain.aggregates.order;

import io.micro_spring_boot.building_blocks.jpa.domain.aggregate.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends AggregateRoot<Order> {
    private PaymentMethod paymentMethod;
    private String address;

    @OneToMany
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private List<OrderLineItem> orderLineItems;
}
