package com.microspringboot.orderservice.domain.events

import java.util.UUID

class OrderPaidEvent(override val orderId: UUID) : OrderEvent

