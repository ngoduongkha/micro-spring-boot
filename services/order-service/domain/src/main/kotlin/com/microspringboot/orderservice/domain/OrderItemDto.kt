package com.microspringboot.orderservice.domain

import java.util.UUID


class OrderItemDto(
    private val productId: UUID,
    private val count: Int
)

