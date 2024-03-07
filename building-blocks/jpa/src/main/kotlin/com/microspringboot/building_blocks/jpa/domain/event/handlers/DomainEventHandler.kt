package com.microspringboot.building_blocks.jpa.domain.event.handlers

import com.microspringboot.building_blocks.jpa.domain.event.DomainEvent
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

interface DomainEventHandler<T : DomainEvent> {
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    fun onApplicationEvent(event: T)
}