package com.microspringboot.orderservice.domain.events

import java.util.*

class OrderProductChangedEvent(
    override val orderId: UUID,
    private val productId: UUID,
    private val originCount: Int,
    private val newCount: Int,
) : OrderEvent

