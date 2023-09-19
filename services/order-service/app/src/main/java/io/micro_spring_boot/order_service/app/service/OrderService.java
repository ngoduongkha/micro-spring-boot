package io.micro_spring_boot.order_service.app.service;

import io.micro_spring_boot.order_service.app.dto.CreateOrderRequest;

public interface OrderService {
    void placeOrder(CreateOrderRequest orderRequest);
}
