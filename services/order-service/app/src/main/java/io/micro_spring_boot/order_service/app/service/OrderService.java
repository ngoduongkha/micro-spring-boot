package io.micro_spring_boot.order_service.app.service;

import io.micro_spring_boot.order_service.app.dto.OrderRequest;

public interface OrderService {
    String placeOrder(OrderRequest orderRequest);
}
