package microspringboot.orderservice.aggregate.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import microspringboot.sharedkernel.domain.AggregateRoot;
import microspringboot.sharedkernel.domain.ConstructorUsedByJPAOnly;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
public class Order extends AggregateRoot<Order> {
    private String paymentMethod;
    private String address;

    @ConstructorUsedByJPAOnly
    public Order() {}
}
