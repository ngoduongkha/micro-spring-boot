package com.microspringboot.productservice.domain.events

import java.math.BigDecimal
import java.time.Instant
import java.util.*

class ProductCreatedEvent(
    override val productId: UUID,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val createdAt: Instant,
) : ProductEvent
