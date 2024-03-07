package com.microspringboot.building_blocks.jpa.domain.event.handlers

import com.microspringboot.building_blocks.jpa.domain.event.DomainEvent
import org.springframework.scheduling.annotation.Async
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

interface DomainEventAsyncHandler<T : DomainEvent> {
    @Async
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun onApplicationEvent(event: T)
}