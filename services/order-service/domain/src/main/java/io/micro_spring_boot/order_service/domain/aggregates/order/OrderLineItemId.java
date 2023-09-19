package io.micro_spring_boot.order_service.domain.aggregates.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderLineItemId implements Serializable {
    private UUID orderId;
    private UUID productId;
}
