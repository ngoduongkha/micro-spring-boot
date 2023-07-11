package microspringboot.orderservice.aggregate.order;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import microspringboot.orderservice.enumeration.PaymentMethod;
import microspringboot.sharedkernel.domain.AggregateRoot;
import microspringboot.sharedkernel.domain.ConstructorUsedByJPAOnly;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
public class Order extends AggregateRoot<Order> {
    private PaymentMethod paymentMethod;
    private String address;

    @OneToMany
    private List<OrderLineItem> orderLineItems;

    @ConstructorUsedByJPAOnly
    public Order() {
        // no-arg constructor for JPA
    }
}
