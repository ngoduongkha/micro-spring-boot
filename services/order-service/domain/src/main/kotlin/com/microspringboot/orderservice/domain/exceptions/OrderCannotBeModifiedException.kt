package com.microspringboot.orderservice.domain.exceptions

import com.microspringboot.building_blocks.shared_kernel.exceptions.AppException
import java.util.UUID


class OrderCannotBeModifiedException(id: UUID) :
    AppException(OrderErrorCode.ORDER_CANNOT_BE_MODIFIED, mapOf("orderId" to id))

