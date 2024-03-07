package com.microspringboot.orderservice.domain.exceptions

import com.microspringboot.building_blocks.shared_kernel.exceptions.AppException
import java.util.*


class PaidPriceNotSameWithOrderPriceException(id: UUID) :
    AppException(OrderErrorCode.PAID_PRICE_NOT_SAME_WITH_ORDER_PRICE, mapOf("orderId" to id))