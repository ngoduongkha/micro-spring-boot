package microspringboot.orderservice.service;

import microspringboot.orderservice.aggregate.order.Order;
import org.springframework.lang.NonNull;

import java.util.List;


public interface OrderService {
    @NonNull
    List<Order> findAll();
}
