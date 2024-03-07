package com.microspringboot.orderservice.app.exceptions

import com.microspringboot.building_blocks.shared_kernel.exceptions.AppException
import com.microspringboot.orderservice.domain.exceptions.OrderErrorCode

class ProductNotInOrderException(productId: String, orderId: String) : AppException(
    OrderErrorCode.PRODUCT_NOT_IN_ORDER, mapOf(
        "productId" to productId,
        "orderId" to orderId
    )
)
