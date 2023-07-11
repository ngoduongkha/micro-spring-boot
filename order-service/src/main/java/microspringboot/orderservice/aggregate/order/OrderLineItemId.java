package microspringboot.orderservice.aggregate.order;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public abstract class OrderLineItemId implements Serializable {
    private UUID orderId;
    private UUID productId;
}
