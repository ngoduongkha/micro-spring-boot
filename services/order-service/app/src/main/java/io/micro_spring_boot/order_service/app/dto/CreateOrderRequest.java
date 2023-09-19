package io.micro_spring_boot.order_service.app.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateOrderRequest(
    @NotEmpty
    List<@Valid OrderLineItem> orderLineItems
) {
    public record OrderLineItem(
        @NotBlank
        String skuCode,
        @Positive
        Integer quantity
    ) { }
}
