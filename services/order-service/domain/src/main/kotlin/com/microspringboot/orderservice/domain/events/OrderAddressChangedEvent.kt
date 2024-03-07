package com.microspringboot.orderservice.domain.events

import java.util.*

class OrderAddressChangedEvent(
    override val orderId: UUID,
    private val oldAddress: String,
    private val newAddress: String) : OrderEvent
