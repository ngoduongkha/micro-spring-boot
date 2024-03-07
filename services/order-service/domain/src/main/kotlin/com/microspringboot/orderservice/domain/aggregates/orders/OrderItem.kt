package com.microspringboot.orderservice.domain.aggregates.orders

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table
import java.io.Serializable
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "order_items")
@IdClass(value = OrderItemId::class)
class OrderItem(
    @Id
    var orderId: UUID,

    @Id
    var productId: UUID,

    var count: Int,

    var price: BigDecimal,
) {
    fun totalPrice(): BigDecimal {
        return price.multiply(BigDecimal(count))
    }

    fun updateCount(count: Int) {
        this.count = count
    }

    constructor(productId: UUID, count: Int, itemPrice: BigDecimal) : this(
        UUID.randomUUID(),
        productId,
        count,
        itemPrice)

    companion object {
        fun create(productId: UUID, count: Int, itemPrice: BigDecimal): OrderItem {
            return OrderItem(productId, count, itemPrice)
        }
    }
}

internal data class OrderItemId(
    var productId: UUID,
    var orderId: UUID
) : Serializable

