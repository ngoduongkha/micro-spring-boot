package com.microspringboot.orderservice.app.services

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.UUID

@Service
class OrderPaymentProxy {
    fun pay(orderId: UUID, paidPrice: BigDecimal) {
        //call remote payment service
    }
}
