package io.micro_spring_boot.building_blocks.jpa.domain.event.handlers;

import io.micro_spring_boot.building_blocks.jpa.domain.event.DomainEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

public interface DomainEventAsyncHandler<T extends DomainEvent> {
    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    void onApplicationEvent(T event);
}