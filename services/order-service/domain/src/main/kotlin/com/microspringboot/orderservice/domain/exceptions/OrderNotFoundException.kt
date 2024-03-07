package com.microspringboot.order_service.app.exceptions

import com.microspringboot.building_blocks.shared_kernel.exceptions.AppException
import com.microspringboot.orderservice.domain.exceptions.OrderErrorCode
import java.util.UUID


class OrderNotFoundException(orderId: UUID) :
    AppException(OrderErrorCode.ORDER_NOT_FOUND, mapOf("orderId" to orderId))

