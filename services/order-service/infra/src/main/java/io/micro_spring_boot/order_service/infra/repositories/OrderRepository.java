package io.micro_spring_boot.order_service.infra.repositories;

import io.micro_spring_boot.order_service.domain.aggregates.order.Order;
import io.micro_spring_boot.building_blocks.jpa.domain.aggregate.AggregateRepository;

public interface OrderRepository extends AggregateRepository<Order> {
}
