package io.micro_spring_boot.order_service.infra.repositories;

import io.micro_spring_boot.order_service.domain.aggregates.order.OrderLineItem;
import io.micro_spring_boot.order_service.domain.aggregates.order.OrderLineItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, OrderLineItemId> {
}
