package microspringboot.orderservice.service.impl;

import lombok.RequiredArgsConstructor;
import microspringboot.orderservice.aggregate.order.Order;
import microspringboot.orderservice.repository.OrderRepository;
import microspringboot.orderservice.service.OrderService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    @NonNull
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }
}
