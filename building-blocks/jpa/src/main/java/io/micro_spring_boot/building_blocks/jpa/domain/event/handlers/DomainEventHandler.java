package io.micro_spring_boot.building_blocks.jpa.domain.event.handlers;

import io.micro_spring_boot.building_blocks.jpa.domain.event.DomainEvent;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

public interface DomainEventHandler<T extends DomainEvent> {
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    void onApplicationEvent(T event);
}