package microspringboot.orderservice.repository;

import microspringboot.orderservice.aggregate.order.Order;
import microspringboot.sharedkernel.repository.Repository;

public interface OrderRepository extends Repository<Order> {
}
