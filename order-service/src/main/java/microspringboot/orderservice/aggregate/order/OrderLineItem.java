package microspringboot.orderservice.aggregate.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "order_line_items")
@IdClass(OrderLineItemId.class)
@RequiredArgsConstructor
@Setter
@Getter
public class OrderLineItem {
    @Id
    private UUID orderId;

    @Id
    private UUID productId;

    private String skuCode;

    private Double price;

    private Integer quantity;
}
