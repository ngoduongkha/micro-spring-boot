package com.microspringboot.orderservice.app.exceptions

import com.microspringboot.building_blocks.shared_kernel.exceptions.AppException
import com.microspringboot.orderservice.domain.exceptions.OrderErrorCode
import java.util.UUID


class OrderNotFoundException(orderId: UUID) :
    AppException(OrderErrorCode.ORDER_NOT_FOUND, mapOf("orderId" to orderId))

