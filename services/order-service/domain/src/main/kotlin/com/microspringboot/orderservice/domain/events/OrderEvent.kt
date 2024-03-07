package com.microspringboot.orderservice.domain.events

import com.microspringboot.building_blocks.shared_kernel.abstraction.DomainEvent
import java.util.UUID

interface OrderEvent : DomainEvent {
    val orderId: UUID
}
