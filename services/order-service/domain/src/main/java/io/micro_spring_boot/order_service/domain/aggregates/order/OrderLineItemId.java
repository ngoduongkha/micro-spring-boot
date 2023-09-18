package io.micro_spring_boot.order_service.domain.aggregates.order;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class OrderLineItemId implements Serializable {
    private UUID orderId;
    private UUID productId;
}
