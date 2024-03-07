package com.microspringboot.orderservice.domain.events

import com.microspringboot.building_blocks.shared_kernel.Address
import com.microspringboot.orderservice.domain.OrderItemDto
import java.math.BigDecimal
import java.util.UUID

class OrderCreatedEvent(
    override val orderId: UUID,
    private val price: BigDecimal,
    private val items: List<OrderItemDto>,
    private val address: Address,
) : OrderEvent

