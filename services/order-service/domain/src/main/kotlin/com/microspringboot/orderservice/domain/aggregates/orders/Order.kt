package com.microspringboot.orderservice.domain.aggregates.orders

import com.microspringboot.building_blocks.jpa.domain.aggregate.AggregateRoot
import com.microspringboot.building_blocks.shared_kernel.Address
import com.microspringboot.orderservice.domain.OrderItemDto
import com.microspringboot.orderservice.domain.exceptions.OrderCannotBeModifiedException
import com.microspringboot.orderservice.domain.exceptions.PaidPriceNotSameWithOrderPriceException
import com.microspringboot.orderservice.domain.exceptions.ProductNotInOrderException
import com.microspringboot.orderservice.domain.events.OrderAddressChangedEvent
import com.microspringboot.orderservice.domain.events.OrderCreatedEvent
import com.microspringboot.orderservice.domain.events.OrderPaidEvent
import com.microspringboot.orderservice.domain.events.OrderProductChangedEvent
import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*
import java.util.stream.Collectors


@Entity
@Table(name = "orders")
class Order(
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "orderId")
    var items: List<OrderItem>,
    var totalPrice: BigDecimal,
    var status: OrderStatus,
    @Embedded
    var address: Address
) : AggregateRoot<Order>() {
    private fun raiseCreatedEvent(id: UUID, items: List<OrderItem>, address: Address) {
        val orderItems = items.stream()
            .map { orderItem ->
                OrderItemDto(
                    orderItem.productId,
                    orderItem.count
                )
            }
            .collect(Collectors.toList())
        registerEvent(OrderCreatedEvent(id, totalPrice, orderItems, address))
    }

    fun changeProductCount(productId: UUID, count: Int) {
        if (status == OrderStatus.PAID) {
            throw OrderCannotBeModifiedException(id)
        }
        val orderItem = retrieveItem(productId)
        val originalCount = orderItem.count
        orderItem.updateCount(count)
        totalPrice = calculateTotalPrice(items)
        registerEvent(OrderProductChangedEvent(id, productId, originalCount, count))
    }

    fun changeAddressDetail(detail: String) {
        if (status == OrderStatus.PAID) {
            throw OrderCannotBeModifiedException(id)
        }
        address = address.changeDetailTo(detail)
        registerEvent(OrderAddressChangedEvent(id, detail, address.detail))
    }

    private fun retrieveItem(productId: UUID): OrderItem {
        return items.stream()
            .filter { item: OrderItem -> item.productId == productId }
            .findFirst()
            .orElseThrow {
                ProductNotInOrderException(
                    productId,
                    id
                )
            }
    }

    fun pay(paidPrice: BigDecimal) {
        if (totalPrice != paidPrice) {
            throw PaidPriceNotSameWithOrderPriceException(id)
        }
        status = OrderStatus.PAID
        registerEvent(OrderPaidEvent(id))
    }

    companion object {
        fun create(items: List<OrderItem>, address: Address): Order {
            val id = UUID.randomUUID()
            val order = Order(items, calculateTotalPrice(items), OrderStatus.CREATED, address)
            order.raiseCreatedEvent(id, items, address)
            return order
        }

        private fun calculateTotalPrice(items: List<OrderItem>): BigDecimal {
            return items.stream()
                .map { item -> item.totalPrice() }
                .reduce(BigDecimal.ZERO, BigDecimal::add)
        }
    }
}

