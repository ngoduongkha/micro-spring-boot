package io.micro_spring_boot.order_service.app.listeners;

import io.micro_spring_boot.order_service.app.events.OrderPlacedEvent;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderPlacedEventListener {
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;
    private final ObservationRegistry observationRegistry;

    @EventListener
    public void handleOrderPlacedEvent(OrderPlacedEvent event) {
        log.info("Order Placed Event Received, Sending OrderPlacedEvent to notificationTopic: {}", event.getOrderId());

        // Create Observation for Kafka Template
        try {
            Observation.createNotStarted("notification-topic", this.observationRegistry).observeChecked(() -> {
                CompletableFuture<SendResult<String, OrderPlacedEvent>> future = kafkaTemplate.send("notificationTopic",
                    new OrderPlacedEvent(event.getOrderId()));
                return future.handle((result, throwable) -> CompletableFuture.completedFuture(result));
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error while sending message to Kafka", e);
        }
    }
}
