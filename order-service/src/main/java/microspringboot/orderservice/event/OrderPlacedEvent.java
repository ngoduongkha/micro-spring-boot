package microspringboot.orderservice.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Getter
@Setter
public class OrderPlacedEvent extends ApplicationEvent {
    private UUID orderId;

    public OrderPlacedEvent(Object source, UUID orderId) {
        super(source);
        this.orderId = orderId;
    }
}
