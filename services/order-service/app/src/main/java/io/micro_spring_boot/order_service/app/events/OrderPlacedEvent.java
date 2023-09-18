package io.micro_spring_boot.order_service.app.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Getter
@Setter
public class OrderPlacedEvent extends ApplicationEvent {
    private final UUID orderId;

    public OrderPlacedEvent(Object source, UUID orderId) {
        super(source);
        this.orderId = orderId;
    }

    public OrderPlacedEvent(UUID orderId) {
        super(orderId);
        this.orderId = orderId;
    }
}
