package microspringboot.orderservice.service;

import microspringboot.orderservice.dto.OrderRequest;

public interface OrderService {
    String placeOrder(OrderRequest orderRequest);
}
