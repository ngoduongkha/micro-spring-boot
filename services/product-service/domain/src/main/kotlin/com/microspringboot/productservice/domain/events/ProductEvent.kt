package com.microspringboot.productservice.domain.events

import com.microspringboot.building_blocks.jpa.domain.event.DomainEvent
import java.util.UUID

interface ProductEvent : DomainEvent {
    val productId: UUID
}
