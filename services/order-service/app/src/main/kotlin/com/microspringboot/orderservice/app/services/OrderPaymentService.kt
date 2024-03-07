package com.microspringboot.orderservice.app.services

import com.microspringboot.orderservice.domain.aggregates.orders.Order
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class OrderPaymentService(
    private val paymentProxy: OrderPaymentProxy
) {
    fun pay(order: Order, paidPrice: BigDecimal) {
        order.pay(paidPrice)
        paymentProxy.pay(order.id, paidPrice)
    }
}

