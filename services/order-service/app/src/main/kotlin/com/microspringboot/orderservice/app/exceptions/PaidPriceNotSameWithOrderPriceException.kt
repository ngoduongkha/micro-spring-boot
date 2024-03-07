package com.microspringboot.orderservice.app.exceptions

import com.microspringboot.building_blocks.shared_kernel.exceptions.AppException
import com.microspringboot.orderservice.domain.exceptions.OrderErrorCode
import java.util.*


class PaidPriceNotSameWithOrderPriceException(id: UUID) :
    AppException(OrderErrorCode.PAID_PRICE_NOT_SAME_WITH_ORDER_PRICE, mapOf("orderId" to id))