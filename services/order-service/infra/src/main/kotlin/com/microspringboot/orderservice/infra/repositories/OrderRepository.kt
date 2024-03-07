package com.microspringboot.orderservice.infra.repositories

import com.microspringboot.building_blocks.jpa.domain.repository.AggregateRepository
import com.microspringboot.orderservice.domain.aggregates.orders.Order

interface OrderRepository : AggregateRepository<Order> {
}